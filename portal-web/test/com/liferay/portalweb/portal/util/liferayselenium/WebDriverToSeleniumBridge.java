/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.util.liferayselenium;

import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.TestPropsValues;

import com.thoughtworks.selenium.Selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Brian Wing Shun Chan
 */
public class WebDriverToSeleniumBridge
	extends WebDriverWrapper implements Selenium {

	public WebDriverToSeleniumBridge(WebDriver webDriver) {
		super(webDriver);

		initKeys();

		_defaultWindowHandle = getWindowHandle();
	}

	public void addCustomRequestHeader(String key, String value) {
		throw new UnsupportedOperationException();
	}

	public void addLocationStrategy(
		String strategyName, String functionDefinition) {

		throw new UnsupportedOperationException();
	}

	public void addScript(String scriptContent, String scriptTagId) {
		throw new UnsupportedOperationException();
	}

	public void addSelection(String locator, String optionLocator) {
		Select select = new Select(getWebElement(locator));

		if (optionLocator.startsWith("index=")) {
			select.selectByIndex(
				GetterUtil.getInteger(optionLocator.substring(6)));
		}
		else if (optionLocator.startsWith("label=")) {
			select.selectByVisibleText(optionLocator.substring(6));
		}
		else if (optionLocator.startsWith("value=")) {
			select.selectByValue(optionLocator.substring(6));
		}
		else {
			select.selectByVisibleText(optionLocator);
		}
	}

	public void allowNativeXpath(String allow) {
		throw new UnsupportedOperationException();
	}

	public void altKeyDown() {
		throw new UnsupportedOperationException();
	}

	public void altKeyUp() {
		throw new UnsupportedOperationException();
	}

	public void answerOnNextPrompt(String answer) {
		throw new UnsupportedOperationException();
	}

	public void assignId(String locator, String identifier) {
		throw new UnsupportedOperationException();
	}

	public void attachFile(String fieldLocator, String fileLocator) {
		throw new UnsupportedOperationException();
	}

	public void captureEntirePageScreenshot(String fileName, String kwargs) {
		throw new UnsupportedOperationException();
	}

	public String captureEntirePageScreenshotToString(String kwargs) {
		throw new UnsupportedOperationException();
	}

	public String captureNetworkTraffic(String type) {
		throw new UnsupportedOperationException();
	}

	public void captureScreenshot(String fileName) {
		throw new UnsupportedOperationException();
	}

	public String captureScreenshotToString() {
		throw new UnsupportedOperationException();
	}

	public void check(String locator) {
		WebElement webElement = getWebElement(locator);

		if (!webElement.isSelected()) {
			webElement.click();
		}
	}

	public void chooseCancelOnNextConfirmation() {
		throw new UnsupportedOperationException();
	}

	public void chooseOkOnNextConfirmation() {
		throw new UnsupportedOperationException();
	}

	public void click(String locator) {
		WebElement webElement = getWebElement(locator);

		webElement.click();
	}

	public void clickAt(String locator, String coordString) {
		WebElement webElement = getWebElement(locator);

		if (coordString.contains(",")) {
			WrapsDriver wrapsDriver = (WrapsDriver)webElement;

			WebDriver webDriver = wrapsDriver.getWrappedDriver();

			Actions actions = new Actions(webDriver);

			String[] coords = coordString.split(",");

			int x = GetterUtil.getInteger(coords[0]);
			int y = GetterUtil.getInteger(coords[1]);

			actions.moveToElement(webElement, x, y);
			actions.click();

			Action action = actions.build();

			action.perform();
		}
		else {
			webElement.click();
		}
	}

	@Override
	public void close() {
		super.close();
	}

	public void contextMenu(String locator) {
		throw new UnsupportedOperationException();
	}

	public void contextMenuAt(String locator, String coordString) {
		throw new UnsupportedOperationException();
	}

	public void controlKeyDown() {
		throw new UnsupportedOperationException();
	}

	public void controlKeyUp() {
		throw new UnsupportedOperationException();
	}

	public void createCookie(String nameValuePair, String optionsString) {
		throw new UnsupportedOperationException();
	}

	public void deleteAllVisibleCookies() {
		throw new UnsupportedOperationException();
	}

	public void deleteCookie(String name, String optionsString) {
		throw new UnsupportedOperationException();
	}

	public void deselectPopUp() {
		throw new UnsupportedOperationException();
	}

	public void doubleClick(String locator) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		actions.doubleClick(webElement);

		Action action = actions.build();

		action.perform();
	}

	public void doubleClickAt(String locator, String coordString) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		if (coordString.contains(",")) {
			String[] coords = coordString.split(",");

			int x = GetterUtil.getInteger(coords[0]);
			int y = GetterUtil.getInteger(coords[1]);

			actions.moveToElement(webElement, x, y);

			actions.doubleClick();
		}
		else {
			actions.doubleClick(webElement);
		}

		Action action = actions.build();

		action.perform();
	}

	public void dragAndDrop(String locator, String movementsString) {
		throw new UnsupportedOperationException();
	}

	public void dragAndDropToObject(
		String locatorOfObjectToBeDragged,
		String locatorOfDragDestinationObject) {

		WebElement objectToBeDraggedWebElement = getWebElement(
			locatorOfObjectToBeDragged);

		WrapsDriver wrapsDriver = (WrapsDriver)objectToBeDraggedWebElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		WebElement dragDestinationObjectWebElement = getWebElement(
			locatorOfDragDestinationObject);

		actions.dragAndDrop(
			objectToBeDraggedWebElement, dragDestinationObjectWebElement);

		Action action = actions.build();

		action.perform();
	}

	public void dragdrop(String locator, String movementsString) {
		throw new UnsupportedOperationException();
	}

	public void fireEvent(String locator, String eventName) {
		throw new UnsupportedOperationException();
	}

	public void focus(String locator) {
		throw new UnsupportedOperationException();
	}

	public String getAlert() {
		switchTo();

		WebDriverWait webDriverWait = new WebDriverWait(this, 1);

		Alert alert = webDriverWait.until(ExpectedConditions.alertIsPresent());

		return alert.getText();
	}

	public String[] getAllButtons() {
		throw new UnsupportedOperationException();
	}

	public String[] getAllFields() {
		throw new UnsupportedOperationException();
	}

	public String[] getAllLinks() {
		throw new UnsupportedOperationException();
	}

	public String[] getAllWindowIds() {
		throw new UnsupportedOperationException();
	}

	public String[] getAllWindowNames() {
		throw new UnsupportedOperationException();
	}

	public String[] getAllWindowTitles() {
		throw new UnsupportedOperationException();
	}

	public String getAttribute(String attributeLocator) {
		int pos = attributeLocator.lastIndexOf(CharPool.AT);

		String locator = attributeLocator.substring(0, pos - 1);

		WebElement webElement = getWebElement(locator);

		String attribute = attributeLocator.substring(pos + 1);

		return webElement.getAttribute(attribute);
	}

	public String[] getAttributeFromAllWindows(String attributeName) {
		throw new UnsupportedOperationException();
	}

	public String getBodyText() {
		WebElement webElement = findElement(By.tagName("body"));

		return webElement.getText();
	}

	public String getConfirmation() {
		switchTo();

		WebDriverWait webDriverWait = new WebDriverWait(this, 1);

		Alert alert = webDriverWait.until(ExpectedConditions.alertIsPresent());

		acceptConfirmation();

		return alert.getText();
	}

	public String getCookie() {
		throw new UnsupportedOperationException();
	}

	public String getCookieByName(String name) {
		throw new UnsupportedOperationException();
	}

	public Number getCssCount(String css) {
		throw new UnsupportedOperationException();
	}

	public Number getCursorPosition(String locator) {
		throw new UnsupportedOperationException();
	}

	public Number getElementHeight(String locator) {
		throw new UnsupportedOperationException();
	}

	public Number getElementIndex(String locator) {
		throw new UnsupportedOperationException();
	}

	public Number getElementPositionLeft(String locator) {
		throw new UnsupportedOperationException();
	}

	public Number getElementPositionTop(String locator) {
		throw new UnsupportedOperationException();
	}

	public Number getElementWidth(String locator) {
		throw new UnsupportedOperationException();
	}

	public String getEval(String script) {
		WebElement webElement = getWebElement("//body");

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)webDriver;

		return (String)javascriptExecutor.executeScript(script);
	}

	public String getExpression(String expression) {
		throw new UnsupportedOperationException();
	}

	public String getHtmlSource() {
		return getPageSource();
	}

	public String getLocation() {
		return getCurrentUrl();
	}

	public String getLog() {
		throw new UnsupportedOperationException();
	}

	public Number getMouseSpeed() {
		throw new UnsupportedOperationException();
	}

	public String getPrompt() {
		throw new UnsupportedOperationException();
	}

	public String getSelectedId(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public String[] getSelectedIds(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public String getSelectedIndex(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public String[] getSelectedIndexes(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public String getSelectedLabel(String selectLocator) {
		WebElement selectLocatorWebElement = getWebElement(selectLocator);

		Select select = new Select(selectLocatorWebElement);

		WebElement firstSelectedOptionWebElement =
			select.getFirstSelectedOption();

		return firstSelectedOptionWebElement.getText();
	}

	public String[] getSelectedLabels(String selectLocator) {
		WebElement selectLocatorWebElement = getWebElement(selectLocator);

		Select select = new Select(selectLocatorWebElement);

		List<WebElement> allSelectedOptionsWebElements =
			select.getAllSelectedOptions();

		return StringUtil.split(
			ListUtil.toString(allSelectedOptionsWebElements, "text"));
	}

	public String getSelectedValue(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public String[] getSelectedValues(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public String[] getSelectOptions(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public String getSpeed() {
		throw new UnsupportedOperationException();
	}

	public String getTable(String tableCellAddress) {
		throw new UnsupportedOperationException();
	}

	public String getText(String locator) {
		WebElement webElement = getWebElement(locator);

		String text = webElement.getText();

		text = text.trim();

		return text.replace("\n", " ");
	}

	@Override
	public String getTitle() {
		return super.getTitle();
	}

	public String getValue(String locator) {
		WebElement webElement = getWebElement(locator);

		return webElement.getAttribute("value");
	}

	public boolean getWhetherThisFrameMatchFrameExpression(
		String currentFrameString, String target) {

		throw new UnsupportedOperationException();
	}

	public boolean getWhetherThisWindowMatchWindowExpression(
		String currentWindowString, String target) {

		throw new UnsupportedOperationException();
	}

	public Number getXpathCount(String xpath) {
		throw new UnsupportedOperationException();
	}

	public void goBack() {
		throw new UnsupportedOperationException();
	}

	public void highlight(String locator) {
		throw new UnsupportedOperationException();
	}

	public void ignoreAttributesWithoutValue(String ignore) {
		throw new UnsupportedOperationException();
	}

	public boolean isAlertPresent() {
		throw new UnsupportedOperationException();
	}

	public boolean isChecked(String locator) {
		WebElement webElement = getWebElement(locator);

		return webElement.isSelected();
	}

	public boolean isConfirmationPresent() {
		throw new UnsupportedOperationException();
	}

	public boolean isCookiePresent(String name) {
		throw new UnsupportedOperationException();
	}

	public boolean isEditable(String locator) {
		throw new UnsupportedOperationException();
	}

	public boolean isElementPresent(String locator) {
		List<WebElement> webElements = getWebElements(locator);

		return !webElements.isEmpty();
	}

	public boolean isOrdered(String locator1, String locator2) {
		throw new UnsupportedOperationException();
	}

	public boolean isPromptPresent() {
		throw new UnsupportedOperationException();
	}

	public boolean isSomethingSelected(String selectLocator) {
		throw new UnsupportedOperationException();
	}

	public boolean isTextPresent(String pattern) {
		WebElement webElement = findElement(By.tagName("body"));

		String text = webElement.getText();

		return text.contains(pattern);
	}

	public boolean isVisible(String locator) {
		WebElement webElement = getWebElement(locator);

		return webElement.isDisplayed();
	}

	public void keyDown(String locator, String keySequence) {
		WebElement webElement = getWebElement(locator);

		if (keySequence.startsWith("\\")) {
			int index = GetterUtil.getInteger(keySequence.substring(1));

			Keys keys = _keysArray[index];

			if ((index >= 48) && (index <= 90)) {
				webElement.sendKeys(StringPool.ASCII_TABLE[index]);
			}
			else if ((index == 16) || (index == 17) || (index == 18)) {
				WrapsDriver wrapsDriver = (WrapsDriver)webElement;

				WebDriver webDriver = wrapsDriver.getWrappedDriver();

				Actions actions = new Actions(webDriver);

				actions.keyDown(webElement, keys);

				Action action = actions.build();

				action.perform();
			}
			else {
				webElement.sendKeys(keys);
			}
		}
		else {
			webElement.sendKeys(keySequence);
		}
	}

	public void keyDownNative(String keycode) {
		throw new UnsupportedOperationException();
	}

	public void keyPress(String locator, String keySequence) {
		WebElement webElement = getWebElement(locator);

		if (keySequence.startsWith("\\")) {
			int index = GetterUtil.getInteger(keySequence.substring(1));

			Keys keys = _keysArray[index];

			if ((index >= 48) && (index <= 90)) {
				webElement.sendKeys(StringPool.ASCII_TABLE[index]);
			}
			else if ((index == 16) || (index == 17) || (index == 18)) {
				WrapsDriver wrapsDriver = (WrapsDriver)webElement;

				WebDriver webDriver = wrapsDriver.getWrappedDriver();

				Actions actions = new Actions(webDriver);

				actions = actions.keyDown(webElement, keys);
				actions = actions.keyUp(webElement, keys);

				Action action = actions.build();

				action.perform();
			}
			else {
				webElement.sendKeys(keys);
			}
		}
		else {
			webElement.sendKeys(keySequence);
		}
	}

	public void keyPressNative(String keycode) {
		throw new UnsupportedOperationException();
	}

	public void keyUp(String locator, String keySequence) {
		WebElement webElement = getWebElement(locator);

		if (keySequence.startsWith("\\")) {
			int index = GetterUtil.getInteger(keySequence.substring(1));

			Keys keys = _keysArray[index];

			if ((index >= 48) && (index <= 90)) {
				webElement.sendKeys(StringPool.ASCII_TABLE[index]);
			}
			else if ((index == 16) || (index == 17) || (index == 18)) {
				WrapsDriver wrapsDriver = (WrapsDriver)webElement;

				WebDriver webDriver = wrapsDriver.getWrappedDriver();

				Actions actions = new Actions(webDriver);

				actions.keyUp(webElement, keys);

				Action action = actions.build();

				action.perform();
			}
			else {
				webElement.sendKeys(keys);
			}
		}
		else {
			webElement.sendKeys(keySequence);
		}
	}

	public void keyUpNative(String keycode) {
		throw new UnsupportedOperationException();
	}

	public void metaKeyDown() {
		throw new UnsupportedOperationException();
	}

	public void metaKeyUp() {
		throw new UnsupportedOperationException();
	}

	public void mouseDown(String locator) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		actions.moveToElement(webElement);
		actions.clickAndHold(webElement);

		Action action = actions.build();

		action.perform();
	}

	public void mouseDownAt(String locator, String coordString) {
		throw new UnsupportedOperationException();
	}

	public void mouseDownRight(String locator) {
		throw new UnsupportedOperationException();
	}

	public void mouseDownRightAt(String locator, String coordString) {
		throw new UnsupportedOperationException();
	}

	public void mouseMove(String locator) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		actions.moveToElement(webElement);
		actions.clickAndHold(webElement);

		Action action = actions.build();

		action.perform();
	}

	public void mouseMoveAt(String locator, String coordString) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		if (coordString.contains(",")) {
			String[] coords = coordString.split(",");

			int x = GetterUtil.getInteger(coords[0]);
			int y = GetterUtil.getInteger(coords[1]);

			actions.moveToElement(webElement, x, y);
			actions.clickAndHold(webElement);
		}
		else {
			actions.moveToElement(webElement);
			actions.clickAndHold(webElement);
		}

		Action action = actions.build();

		action.perform();
	}

	public void mouseOut(String locator) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		actions.moveToElement(webElement);
		actions.moveByOffset(10, 10);

		Action action = actions.build();

		action.perform();
	}

	public void mouseOver(String locator) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		actions.moveToElement(webElement);

		Action action = actions.build();

		action.perform();
	}

	public void mouseUp(String locator) {
		WebElement webElement = getWebElement(locator);

		WrapsDriver wrapsDriver = (WrapsDriver)webElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		actions.release(webElement);

		Action action = actions.build();

		action.perform();
	}

	public void mouseUpAt(String locator, String coordString) {
		throw new UnsupportedOperationException();
	}

	public void mouseUpRight(String locator) {
		throw new UnsupportedOperationException();
	}

	public void mouseUpRightAt(String locator, String coordString) {
		throw new UnsupportedOperationException();
	}

	public void open(String url) {
		if (url.startsWith("/")) {
			get(TestPropsValues.PORTAL_URL + url);
		}
		else {
			get(url);
		}

		if (TestPropsValues.BROWSER_TYPE.equals("*iehta") ||
			TestPropsValues.BROWSER_TYPE.equals("*iexplore")) {

			refresh();
		}
	}

	public void open(String url, String ignoreResponseCode) {
		throw new UnsupportedOperationException();
	}

	public void openWindow(String url, String windowID) {
		open(url);
	}

	public void refresh() {
		WebDriver.Navigation navigation = navigate();

		navigation.refresh();
	}

	public void removeAllSelections(String locator) {
		throw new UnsupportedOperationException();
	}

	public void removeScript(String scriptTagId) {
		throw new UnsupportedOperationException();
	}

	public void removeSelection(String locator, String optionLocator) {
		throw new UnsupportedOperationException();
	}

	public String retrieveLastRemoteControlLogs() {
		throw new UnsupportedOperationException();
	}

	public void rollup(String rollupName, String kwargs) {
		throw new UnsupportedOperationException();
	}

	public void runScript(String script) {
		throw new UnsupportedOperationException();
	}

	public void select(String selectLocator, String optionLocator) {
		WebElement webElement = getWebElement(selectLocator);

		webElement.click();

		Select select = new Select(webElement);

		List<WebElement> options = select.getOptions();

		WebElement optionWebElement = null;

		if (optionLocator.startsWith("index=")) {
			String index = optionLocator.substring(6);

			int optionIndex = GetterUtil.getInteger(index);

			optionWebElement = options.get(optionIndex);
		}
		else if (optionLocator.startsWith("value=")) {
			String value = optionLocator.substring(6);

			for (WebElement option : options) {
				String optionValue = option.getAttribute("value");

				if (optionValue.equals(value)) {
					optionWebElement = option;

					break;
				}
			}
		}
		else {
			String label = optionLocator;

			if (optionLocator.startsWith("label=")) {
				label = optionLocator.substring(6);
			}

			for (WebElement option : options) {
				String optionText = option.getText();

				if (optionText.equals(label)) {
					optionWebElement = option;

					break;
				}
			}
		}

		WrapsDriver wrapsDriver = (WrapsDriver)optionWebElement;

		WebDriver webDriver = wrapsDriver.getWrappedDriver();

		Actions actions = new Actions(webDriver);

		actions.doubleClick(optionWebElement);

		Action action = actions.build();

		action.perform();
	}

	public void selectFrame(String locator) {
		WebDriver.TargetLocator targetLocator = switchTo();

		if (locator.equals("relative=parent")) {
			throw new UnsupportedOperationException();
		}
		else if (locator.equals("relative=top")) {
			targetLocator.window(_defaultWindowHandle);
		}
		else {
			WebElement webElement = getWebElement(locator);

			targetLocator.frame(webElement);
		}
	}

	public void selectPopUp(String windowID) {
		Set<String> windowHandles = getWindowHandles();

		if (windowID.equals("") || windowID.equals("null")) {
			String currentWindowTitle = getTitle();

			for (String windowHandle : windowHandles) {
				WebDriver.TargetLocator targetLocator = switchTo();

				targetLocator.window(windowHandle);

				if (!currentWindowTitle.equals(getTitle())) {
					return;
				}
			}

			BaseTestCase.fail(
				"Unable to find the window ID \"" + windowID + "\"");
		}
		else {
			selectWindow(windowID);
		}
	}

	public void selectWindow(String windowID) {
		Set<String> windowHandles = getWindowHandles();

		if (windowID.equals("null")) {
			WebDriver.TargetLocator targetLocator = switchTo();

			targetLocator.window(_defaultWindowHandle);
		}
		else {
			String targetWindowTitle = windowID;

			if (targetWindowTitle.startsWith("title=")) {
				targetWindowTitle = targetWindowTitle.substring(6);
			}

			for (String windowHandle : windowHandles) {
				WebDriver.TargetLocator targetLocator = switchTo();

				targetLocator.window(windowHandle);

				if (targetWindowTitle.equals(getTitle())) {
					return;
				}
			}

			BaseTestCase.fail(
				"Unable to find the window ID \"" + windowID + "\"");
		}
	}

	public void setBrowserLogLevel(String logLevel) {
		throw new UnsupportedOperationException();
	}

	public void setContext(String context) {
		throw new UnsupportedOperationException();
	}

	public void setCursorPosition(String locator, String position) {
		throw new UnsupportedOperationException();
	}

	public void setExtensionJs(String extensionJs) {
		throw new UnsupportedOperationException();
	}

	public void setMouseSpeed(String pixels) {
		throw new UnsupportedOperationException();
	}

	public void setSpeed(String value) {
		throw new UnsupportedOperationException();
	}

	public void setTimeout(String timeout) {
		WebDriver.Options options = manage();

		Timeouts timeouts = options.timeouts();

		timeouts.implicitlyWait(
			TestPropsValues.TIMEOUT_IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void shiftKeyDown() {
		throw new UnsupportedOperationException();
	}

	public void shiftKeyUp() {
		throw new UnsupportedOperationException();
	}

	public void showContextualBanner() {
		throw new UnsupportedOperationException();
	}

	public void showContextualBanner(String className, String methodName) {
		throw new UnsupportedOperationException();
	}

	public void shutDownSeleniumServer() {
		throw new UnsupportedOperationException();
	}

	public void start() {
		throw new UnsupportedOperationException();
	}

	public void start(Object optionsObject) {
		throw new UnsupportedOperationException();
	}

	public void start(String optionsString) {
		throw new UnsupportedOperationException();
	}

	public void stop() {
		quit();
	}

	public void submit(String formLocator) {
		throw new UnsupportedOperationException();
	}

	public void type(String locator, String value) {
		WebElement webElement = getWebElement(locator);

		if (webElement.isEnabled()) {
			webElement.clear();

			webElement.sendKeys(value);
		}
	}

	public void typeKeys(String locator, String value) {
		WebElement webElement = getWebElement(locator);

		if (webElement.isEnabled()) {
			webElement.sendKeys(value);
		}
	}

	public void uncheck(String locator) {
		WebElement webElement = getWebElement(locator);

		if (webElement.isSelected()) {
			webElement.click();
		}
	}

	public void useXpathLibrary(String libraryName) {
		throw new UnsupportedOperationException();
	}

	public void waitForCondition(String script, String timeout) {
		throw new UnsupportedOperationException();
	}

	public void waitForFrameToLoad(String frameAddress, String timeout) {
		throw new UnsupportedOperationException();
	}

	public void waitForPageToLoad(String timeout) {
	}

	public void waitForPopUp(String windowID, String timeout) {
		int wait = 0;

		if (timeout.equals("")) {
			wait = 30;
		}
		else {
			wait = GetterUtil.getInteger(timeout) / 1000;
		}

		if (windowID.equals("") || windowID.equals("null")) {
			for (int i = 0; i <= wait; i++) {
				Set<String> windowHandles = getWindowHandles();

				if (windowHandles.size() > 1) {
					return;
				}

				try {
					Thread.sleep(1000);
				}
				catch (Exception e) {
				}
			}
		}
		else {
			String targetWindowTitle = windowID;

			if (targetWindowTitle.startsWith("title=")) {
				targetWindowTitle = targetWindowTitle.substring(6);
			}

			for (int i = 0; i <= wait; i++) {
				for (String windowHandle : getWindowHandles()) {
					WebDriver.TargetLocator targetLocator = switchTo();

					targetLocator.window(windowHandle);

					if (targetWindowTitle.equals(getTitle())) {
						targetLocator.window(_defaultWindowHandle);

						return;
					}
				}

				try {
					Thread.sleep(1000);
				}
				catch (Exception e) {
				}
			}
		}

		BaseTestCase.fail("Unable to find the window ID \"" + windowID + "\"");
	}

	public void windowFocus() {
		throw new UnsupportedOperationException();
	}

	public void windowMaximize() {
		throw new UnsupportedOperationException();
	}

	protected void acceptConfirmation() {
		WebDriver.TargetLocator targetLocator = switchTo();

		Alert alert = targetLocator.alert();

		alert.accept();
	}

	protected WebElement getWebElement(String locator) {
		WebDriverWait webDriverWait = new WebDriverWait(
			this, TestPropsValues.TIMEOUT_IMPLICIT_WAIT);

		if (locator.startsWith("//")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}
		else if (locator.startsWith("class=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(
					By.className(locator.substring(6))));
		}
		else if (locator.startsWith("css=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(
					By.cssSelector(locator.substring(4))));
		}
		else if (locator.startsWith("link=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(
					By.linkText(locator.substring(5))));
		}
		else if (locator.startsWith("name=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(
					By.name(locator.substring(5))));
		}
		else if (locator.startsWith("tag=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(
					By.tagName(locator.substring(4))));
		}
		else if (locator.startsWith("xpath=") || locator.startsWith("xPath=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(
					By.xpath(locator.substring(6))));
		}
		else {
			return webDriverWait.until(
				ExpectedConditions.presenceOfElementLocated(By.id(locator)));
		}
	}

	protected List<WebElement> getWebElements(String locator) {
		WebDriverWait webDriverWait = new WebDriverWait(
			this, TestPropsValues.TIMEOUT_IMPLICIT_WAIT);

		if (locator.startsWith("//")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.xpath(locator)));
		}
		else if (locator.startsWith("class=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.className(locator.substring(6))));
		}
		else if (locator.startsWith("css=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.cssSelector(locator.substring(4))));
		}
		else if (locator.startsWith("link=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.linkText(locator.substring(5))));
		}
		else if (locator.startsWith("name=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.name(locator.substring(5))));
		}
		else if (locator.startsWith("tag=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.tagName(locator.substring(4))));
		}
		else if (locator.startsWith("xpath=") || locator.startsWith("xPath=")) {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.xpath(locator.substring(6))));
		}
		else {
			return webDriverWait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.id(locator)));
		}
	}

	protected void initKeys() {

		// ASCII to WebDriver

		_keysArray[107] = Keys.ADD;
		_keysArray[18] = Keys.ALT;
		_keysArray[40] = Keys.ARROW_DOWN;
		_keysArray[37] = Keys.ARROW_LEFT;
		_keysArray[39] = Keys.ARROW_RIGHT;
		_keysArray[38] = Keys.ARROW_UP;
		_keysArray[8] = Keys.BACK_SPACE;
		//keyTable[] = Keys.CANCEL;
		//keyTable[] = Keys.CLEAR;
		//keyTable[] = Keys.COMMAND;
		_keysArray[17] = Keys.CONTROL;
		_keysArray[110] = Keys.DECIMAL;
		_keysArray[46] = Keys.DELETE;
		_keysArray[111] = Keys.DIVIDE;
		//keyTable[] = Keys.DOWN;
		//keyTable[] = Keys.END;
		_keysArray[13] = Keys.RETURN;
		//keyTable[] = Keys.EQUALS;
		_keysArray[27] = Keys.ESCAPE;
		_keysArray[112] = Keys.F1;
		_keysArray[121] = Keys.F10;
		_keysArray[122] = Keys.F11;
		_keysArray[123] = Keys.F12;
		_keysArray[113] = Keys.F2;
		_keysArray[114] = Keys.F3;
		_keysArray[115] = Keys.F4;
		_keysArray[116] = Keys.F5;
		_keysArray[117] = Keys.F6;
		_keysArray[118] = Keys.F7;
		_keysArray[119] = Keys.F8;
		_keysArray[120] = Keys.F9;
		//keyTable[] = Keys.HELP;
		_keysArray[36] = Keys.HOME;
		_keysArray[45] = Keys.INSERT;
		//keyTable[] = Keys.LEFT;
		//keyTable[] = Keys.LEFT_ALT;
		//keyTable[] = Keys.LEFT_CONTROL;
		//keyTable[] = Keys.LEFT_SHIFT;
		//keyTable[] = Keys.META;
		//keyTable[] = Keys.NULL;
		_keysArray[96] = Keys.NUMPAD0;
		_keysArray[97] = Keys.NUMPAD1;
		_keysArray[98] = Keys.NUMPAD2;
		_keysArray[99] = Keys.NUMPAD3;
		_keysArray[100] = Keys.NUMPAD4;
		_keysArray[101] = Keys.NUMPAD5;
		_keysArray[102] = Keys.NUMPAD6;
		_keysArray[103] = Keys.NUMPAD7;
		_keysArray[104] = Keys.NUMPAD8;
		_keysArray[105] = Keys.NUMPAD9;
		_keysArray[34] = Keys.PAGE_DOWN;
		_keysArray[33] = Keys.PAGE_UP;
		_keysArray[19] = Keys.PAUSE;
		//keyTable[] = Keys.RETURN;
		//keyTable[] = Keys.RIGHT;
		//keyTable[] = Keys.SEMICOLON;
		//keyTable[] = Keys.SEPARATOR;
		_keysArray[16] = Keys.SHIFT;
		_keysArray[32] = Keys.SPACE;
		_keysArray[109] = Keys.SUBTRACT;
		_keysArray[9] = Keys.TAB;
		//keyTable[] = Keys.UP;
	}

	private String _defaultWindowHandle;
	private Keys[] _keysArray = new Keys[128];

}