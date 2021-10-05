package com.jsf.guessnumber.example;

import java.util.Random;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.LongRangeValidator;
import javax.faces.validator.ValidatorException;

public class UserNumberBean {

	private int maximum = 0;
	private int minimum = 0;
	private String[] status = null;
	private String response = null;
	private Integer randomInt = null;
	private Integer userNumber = null;
	private boolean btnValue = false;
	private boolean maximumSet = false;
	private boolean minimumSet = false;

	// Generating Random Number At Application Start-Up Which Will Be Used To Test The Application
	public UserNumberBean() {
		Random randomNum = new Random();
		do {
			randomInt = new Integer(randomNum.nextInt(10));
		} while (randomInt.intValue() == 0);
		System.out.println("Selected Random Number Is?: " + randomInt);
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
		this.maximumSet = true;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
		this.minimumSet = true;
	}

	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}

	// Check Whether The Entered Number Is Correct Or Incorrect. 
	public String getResponse() {		
		if (userNumber != null && userNumber.compareTo(randomInt) == 0) {
			setBtnValue(true);
			response = "Congratulations! You got it correct!";
			Random randomNum = new Random();
			randomInt = new Integer(randomNum.nextInt(10));
		} else if (userNumber == null) {
			response = "Sorry, " + userNumber + " is incorrect. Try a larger number.";
		} else {
			int enteredNum = userNumber.intValue();
			System.out.println("Number Entered By User Is?= " + enteredNum);
			if (enteredNum > randomInt.intValue()) {
				response = "Sorry, " + userNumber + " is incorrect. Try a smaller number.";
			} else {
				response = "Sorry, " + userNumber +" is incorrect. Try a larger number.";
			}
		}
		return response;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public boolean isBtnValue() {
		return btnValue;
	}

	public void setBtnValue(boolean btnValue) {
		this.btnValue = btnValue;
	}

	public boolean isMaximumSet() {
		return maximumSet;
	}

	public void setMaximumSet(boolean maximumSet) {
		this.maximumSet = maximumSet;
	}

	public boolean isMinimumSet() {
		return minimumSet;
	}

	public void setMinimumSet(boolean minimumSet) {
		this.minimumSet = minimumSet;
	}

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
		if (value != null) {
			try {
				int converted = intValue(value);
				if (maximumSet && (converted > maximum)) {
					if (minimumSet) {
						throw new ValidatorException(MessageFactory.getMessage (context, LongRangeValidator.NOT_IN_RANGE_MESSAGE_ID, new Object[] {
								new Integer(minimum), new Integer(maximum), MessageFactory.getLabel(context, component)
						}));
					} else {
						throw new ValidatorException(MessageFactory.getMessage(context, LongRangeValidator.MAXIMUM_MESSAGE_ID, new Object[] {
								new Integer(maximum), MessageFactory.getLabel(context, component)
						}));
					}
				}
				if (minimumSet && (converted < minimum)) {
					if (maximumSet) {
						throw new ValidatorException(MessageFactory.getMessage (context, LongRangeValidator.NOT_IN_RANGE_MESSAGE_ID, new Object[] {
								new Double(minimum), new Double(maximum), MessageFactory.getLabel(context, component)
						}));
					} else {
						throw new ValidatorException(MessageFactory.getMessage (context, LongRangeValidator.MINIMUM_MESSAGE_ID, new Object[] {
								new Integer(minimum), MessageFactory.getLabel(context, component)
						}));
					}
				}
				if (userNumber != null && userNumber.compareTo(randomInt) == 0) {
					setBtnValue(true);
					response = "Congratulations! You got it correct!";
					Random randomNum = new Random();
					randomInt = new Integer(randomNum.nextInt(10));
					userNumber = null;
				} 
			} catch (NumberFormatException e) {
				throw new ValidatorException(MessageFactory.getMessage (context, LongRangeValidator.TYPE_MESSAGE_ID, new Object[] {
						MessageFactory.getLabel(context, component)
				}));
			}
		}
	}

	private int intValue(Object attributeValue) throws NumberFormatException {
		if (attributeValue instanceof Number) {
			return ((Number) attributeValue).intValue();
		} else {
			return Integer.parseInt(attributeValue.toString());
		}
	}
}