package org.jbehave.scenario.parser;

import static org.jbehave.Ensure.ensureThat;

import org.hamcrest.CoreMatchers;
import org.jbehave.scenario.parser.CamelCaseToUnderscoreConverter;
import org.junit.Test;

public class CamelCaseToUnderscoreConverterBehaviour {

	@Test
	public void shouldConvertCamelCasedScenarioNameToUnderscore() {
		CamelCaseToUnderscoreConverter converter = new CamelCaseToUnderscoreConverter();
		ensureThat(converter.convert(CamelCaseToUnderscoreConverterBehaviour.class), CoreMatchers.equalTo("org/jbehave/scenario/parser/camel_case_to_underscore_converter_behaviour"));
		
	}
}