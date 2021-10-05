package com.jsf.guessnumber.example;

import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageFactory extends Object {   

	private MessageFactory() { }

	public static FacesMessage getMessage(String messageId, Object params[]) {
		Locale locale = null;
		if (FacesContext.getCurrentInstance() != null && FacesContext.getCurrentInstance().getViewRoot() != null) {
			locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
			if (locale == null) {
				locale = Locale.getDefault();
			}
		} else {
			locale = Locale.getDefault();
		}
		return getMessage(locale, messageId, params);
	}

	public static FacesMessage getMessage(Locale locale, String messageId, Object params[]) {
		String summary = null, detail = null, bundleName = null; 
		ResourceBundle bundle = null;

		// Check Whether User Has Provided A Bundle Or Not
		if (null != (bundleName = getApplication().getMessageBundle())) {
			if (null != (bundle = ResourceBundle.getBundle(bundleName, locale, getCurrentLoader(bundleName)))) {
				try {
					summary = bundle.getString(messageId);
					detail = bundle.getString(messageId + "_detail");
				}
				catch (MissingResourceException missingResourceExceptionObj) {
				}
			}
		}

		// Couldn't Find Summary In User Bundle
		if (null == summary) {
			bundle = ResourceBundle.getBundle(FacesMessage.FACES_MESSAGES, locale, getCurrentLoader(bundleName));
			if (null == bundle) {
				throw new NullPointerException();
			}
			try {
				summary = bundle.getString(messageId);
				detail = bundle.getString(messageId + "_detail");
			}
			catch (MissingResourceException missingResourceExceptionObj) {
			}
		}

		// If We Couldn't Find A Summary Anywhere, Return Null
		if (null == summary) {
			return null;
		}

		if (null == summary || null == bundle) {
			throw new NullPointerException(" summary " + summary + " bundle " + bundle);
		}
		return (new BindingFacesMessage(locale, summary, detail, params));
	}

	// Methods From MessageFactory Class    
	public static FacesMessage getMessage(FacesContext context, String messageId) {
		return getMessage(context, messageId, null);
	}

	public static FacesMessage getMessage(FacesContext context, String messageId, Object params[]) {
		if (context == null || messageId == null) {
			throw new NullPointerException(" context " + context + " messageId " +messageId);
		}

		Locale locale = null;
		// ViewRoot May Not Have Been Initialized At This Point
		if (context != null && context.getViewRoot() != null) {
			locale = context.getViewRoot().getLocale();
		} else {
			locale = Locale.getDefault();
		}

		if (null == locale) {
			throw new NullPointerException(" locale " + locale);
		}

		FacesMessage message = getMessage(locale, messageId, params);
		if (message != null) {
			return message;
		}

		locale = Locale.getDefault();
		return getMessage(locale, messageId, params);
	}

	public static FacesMessage getMessage(FacesContext context, String messageId, Object param0) {
		return getMessage(context, messageId, new Object[] {param0});
	}

	public static FacesMessage getMessage(FacesContext context, String messageId, Object param0, Object param1) {
		return getMessage(context, messageId, new Object[] {param0, param1});
	}

	public static FacesMessage getMessage(FacesContext context, String messageId, Object param0, Object param1, Object param2) {
		return getMessage(context, messageId, new Object[] {param0, param1, param2});
	}

	public static FacesMessage getMessage(FacesContext context, String messageId, Object param0, Object param1, Object param2, Object param3) {
		return getMessage(context, messageId, new Object[] {param0, param1, param2, param3});
	}

	// Gets The "Label" Property From The Component
	public static Object getLabel(FacesContext context, UIComponent component) {
		Object o = component.getAttributes().get("label");
		if (o == null) {
			o = component.getValueExpression("label");
		}
		// Use The "clientId" If There Was No Label Specified.
		if (o == null) {
			o = component.getClientId(context);
		}
		return o;
	}

	public static Application getApplication() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			return (FacesContext.getCurrentInstance().getApplication());
		}
		ApplicationFactory afactory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
		return (afactory.getApplication());
	}

	public static ClassLoader getCurrentLoader(Object fallbackClass) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = fallbackClass.getClass().getClassLoader();
		}
		return loader;
	}

	private static class BindingFacesMessage extends FacesMessage {

		private Locale locale;
		private Object[] parameters;
		private Object[] resolvedParameters;

		private static final long serialVersionUID = 1L;
		BindingFacesMessage(Locale locale, String messageFormat, String detailMessageFormat, Object[] parameters) {
			super(messageFormat, detailMessageFormat);
			this.locale = locale;
			this.parameters = parameters;
			if (parameters != null) {
				resolvedParameters = new Object[parameters.length];
			}
		}

		public String getSummary() {
			String pattern = super.getSummary();
			resolveBindings();
			return getFormattedString(pattern, resolvedParameters);
		}

		public String getDetail() {
			String pattern = super.getDetail();
			resolveBindings();
			return getFormattedString(pattern, resolvedParameters);
		}

		private void resolveBindings() {
			FacesContext context = null;
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					Object o = parameters[i];
					if (o instanceof ValueExpression) {
						if (context == null) {
							context = FacesContext.getCurrentInstance();
						}
						o = ((ValueExpression) o).getValue(context.getELContext());
					}		

					if (o == null) {
						o = "";
					}
					resolvedParameters[i] = o;
				}
			}
		}

		private String getFormattedString(String msgtext, Object[] params) {
			String localizedStr = null;
			if (params == null || msgtext == null) {
				return msgtext;
			}

			StringBuffer b = new StringBuffer(100);
			MessageFormat mf = new MessageFormat(msgtext);
			if (locale != null) {
				mf.setLocale(locale);
				b.append(mf.format(params));
				localizedStr = b.toString();
			}
			return localizedStr;
		}
	}
} 