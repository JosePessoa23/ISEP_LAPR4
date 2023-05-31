package eapli.base.surveymanagement.application.grammar;

import eapli.base.surveymanagement.application.grammar.ANTLR.SurveyGrammarLexer;
import eapli.base.surveymanagement.application.grammar.ANTLR.SurveyGrammarParser;
import eapli.base.surveymanagement.domain.Survey;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Grammar {

    public Grammar() {
    }

    public Survey checkSurvey (String file) throws IOException {
        FileInputStream fis = new FileInputStream(new File(file));
        SurveyGrammarLexer lexer = new SurveyGrammarLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SurveyGrammarParser parser = new SurveyGrammarParser(tokens);
        ParseTree tree = parser.prog(); // parse
        SurveyVisitor svisit = new SurveyVisitor();
        return (Survey) svisit.visit(tree);
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Rita Lello\\Documents\\lei21_22_s4_2de_02\\documentação\\Ficheiros questionarios\\teste_2.txt");
        SurveyGrammarLexer lexer = new SurveyGrammarLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SurveyGrammarParser parser = new SurveyGrammarParser(tokens);
        ParseTree tree = parser.prog(); // parse
        SurveyVisitor svisit = new SurveyVisitor();
        Survey survey = (Survey) svisit.visit(tree);
        System.out.println(survey);
    }

}
