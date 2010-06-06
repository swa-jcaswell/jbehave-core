package org.jbehave.core.reporters;

import java.io.PrintStream;
import java.util.Properties;

import org.jbehave.core.model.Keywords;

/**
 * <p>
 * Story reporter that outputs to a PrintStream, as XML. It extends
 * {@link PrintStreamOutput}, providing XML-based default output
 * patterns, which can be overridden via the {@link
 * XmlOutput (PrintStream,Properties)} constructor.
 * </p>
 * 
 * @author Mauro Talevi
 */
public class XmlOutput extends PrintStreamOutput {

    public XmlOutput(PrintStream output) {
        this(output, defaultHtmlPatterns());
    }

    public XmlOutput(PrintStream output, Properties outputPatterns) {
        super(mergeWithDefault(outputPatterns), Format.XML);
        usePrintStream(output);
    }
    
    public XmlOutput(PrintStream output, Properties outputPatterns,
            Keywords keywords, boolean reportErrors) {
        super(output, mergeWithDefault(outputPatterns), Format.XML, keywords, reportErrors);
    }

    private static Properties mergeWithDefault(Properties outputPatterns) {
        Properties patterns = defaultHtmlPatterns();
        // override any default pattern
        patterns.putAll(outputPatterns);
        return patterns;
    }

    private static Properties defaultHtmlPatterns() {
        Properties patterns = new Properties();
        patterns.setProperty("successful", "<step outcome=\"successful\">{0}</step>\n");
        patterns.setProperty("ignorable", "<step outcome=\"ignorable\">{0}</step>\n");
        patterns.setProperty("pending", "<step outcome=\"pending\" keyword=\"{1}\">{0}</step>\n");
        patterns.setProperty("notPerformed", "<step outcome=\"notPerformed\" keyword=\"{1}\">{0}</step>\n");
        patterns.setProperty("failed", "<step outcome=\"failed\" keyword=\"{1}\">{0}</step>\n");
        patterns.setProperty("beforeStory", "<story path=\"{1}\" title=\"{0}\">\n");
        patterns.setProperty("narrative", "<narrative keyword=\"{0}\">\n  <inOrderTo keyword=\"{1}\">{2}</inOrderTo>\n  <asA keyword=\"{3}\">{4}</asA>\n  <iWantTo keyword=\"{5}\">{6}</iWantTo>\n</narrative>\n");
        patterns.setProperty("afterStory", "</story>\n");
        patterns.setProperty("beforeScenario", "<core keyword=\"{0}\" title=\"{1}\">\n");
        patterns.setProperty("afterScenario", "</core>\n");
        patterns.setProperty("afterScenarioWithFailure", "<failure>{0}</failure>\n</core>\n");
        patterns.setProperty("givenStories", "<givenStories keyword=\"{0}\"paths=\"{1}\"</givenStories>\n");
        patterns.setProperty("beforeExamples", "<examples keyword=\"{0}\">\n");
        patterns.setProperty("examplesStep", "<step>{0}</step>\n");
        patterns.setProperty("afterExamples", "</examples>\n");
        patterns.setProperty("examplesTableStart", "<parameters>\n");
        patterns.setProperty("examplesTableHeadStart", "<names>");
        patterns.setProperty("examplesTableHeadCell", "<name>{0}</name>");
        patterns.setProperty("examplesTableHeadEnd", "</names>\n");
        patterns.setProperty("examplesTableBodyStart", "");
        patterns.setProperty("examplesTableRowStart", "<values>");
        patterns.setProperty("examplesTableCell", "<value>{0}</value>");
        patterns.setProperty("examplesTableRowEnd", "</values>\n");
        patterns.setProperty("examplesTableBodyEnd", "");
        patterns.setProperty("examplesTableEnd", "</parameters>\n");
        patterns.setProperty("example", "\n<example keyword=\"{0}\">{1}</example>\n");
        patterns.setProperty("parameterValueStart", "<parameter>");
        patterns.setProperty("parameterValueEnd", "</parameter>");
        patterns.setProperty("parameterValueNewline", "\n");        
        patterns.setProperty("dryRun", "<dryRun>{0}</dryRun>\n");        
        return patterns;
    }

}
