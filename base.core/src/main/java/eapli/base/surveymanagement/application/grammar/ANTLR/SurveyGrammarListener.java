// Generated from C:/Users/Rita Lello/Documents/lei21_22_s4_2de_02/base.core/src/main/java/eapli/base/surveymanagement/application/grammar\SurveyGrammar.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.grammar.ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SurveyGrammarParser}.
 */
public interface SurveyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SurveyGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SurveyGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code questionario}
	 * labeled alternative in {@link SurveyGrammarParser#survey}.
	 * @param ctx the parse tree
	 */
	void enterQuestionario(SurveyGrammarParser.QuestionarioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code questionario}
	 * labeled alternative in {@link SurveyGrammarParser#survey}.
	 * @param ctx the parse tree
	 */
	void exitQuestionario(SurveyGrammarParser.QuestionarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#surveyID}.
	 * @param ctx the parse tree
	 */
	void enterSurveyID(SurveyGrammarParser.SurveyIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#surveyID}.
	 * @param ctx the parse tree
	 */
	void exitSurveyID(SurveyGrammarParser.SurveyIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#alphanumeric}.
	 * @param ctx the parse tree
	 */
	void enterAlphanumeric(SurveyGrammarParser.AlphanumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#alphanumeric}.
	 * @param ctx the parse tree
	 */
	void exitAlphanumeric(SurveyGrammarParser.AlphanumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(SurveyGrammarParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(SurveyGrammarParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#welcomeMessage}.
	 * @param ctx the parse tree
	 */
	void enterWelcomeMessage(SurveyGrammarParser.WelcomeMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#welcomeMessage}.
	 * @param ctx the parse tree
	 */
	void exitWelcomeMessage(SurveyGrammarParser.WelcomeMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(SurveyGrammarParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(SurveyGrammarParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#sectionList}.
	 * @param ctx the parse tree
	 */
	void enterSectionList(SurveyGrammarParser.SectionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#sectionList}.
	 * @param ctx the parse tree
	 */
	void exitSectionList(SurveyGrammarParser.SectionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#finalMessage}.
	 * @param ctx the parse tree
	 */
	void enterFinalMessage(SurveyGrammarParser.FinalMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#finalMessage}.
	 * @param ctx the parse tree
	 */
	void exitFinalMessage(SurveyGrammarParser.FinalMessageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seccao}
	 * labeled alternative in {@link SurveyGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSeccao(SurveyGrammarParser.SeccaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seccao}
	 * labeled alternative in {@link SurveyGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSeccao(SurveyGrammarParser.SeccaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#sectionID}.
	 * @param ctx the parse tree
	 */
	void enterSectionID(SurveyGrammarParser.SectionIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#sectionID}.
	 * @param ctx the parse tree
	 */
	void exitSectionID(SurveyGrammarParser.SectionIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#shortDescription}.
	 * @param ctx the parse tree
	 */
	void enterShortDescription(SurveyGrammarParser.ShortDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#shortDescription}.
	 * @param ctx the parse tree
	 */
	void exitShortDescription(SurveyGrammarParser.ShortDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void enterObligatoriness(SurveyGrammarParser.ObligatorinessContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void exitObligatoriness(SurveyGrammarParser.ObligatorinessContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(SurveyGrammarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(SurveyGrammarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(SurveyGrammarParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(SurveyGrammarParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code questao}
	 * labeled alternative in {@link SurveyGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestao(SurveyGrammarParser.QuestaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code questao}
	 * labeled alternative in {@link SurveyGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestao(SurveyGrammarParser.QuestaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#questionID}.
	 * @param ctx the parse tree
	 */
	void enterQuestionID(SurveyGrammarParser.QuestionIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#questionID}.
	 * @param ctx the parse tree
	 */
	void exitQuestionID(SurveyGrammarParser.QuestionIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#questionSentence}.
	 * @param ctx the parse tree
	 */
	void enterQuestionSentence(SurveyGrammarParser.QuestionSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#questionSentence}.
	 * @param ctx the parse tree
	 */
	void exitQuestionSentence(SurveyGrammarParser.QuestionSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SurveyGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SurveyGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#choices}.
	 * @param ctx the parse tree
	 */
	void enterChoices(SurveyGrammarParser.ChoicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#choices}.
	 * @param ctx the parse tree
	 */
	void exitChoices(SurveyGrammarParser.ChoicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(SurveyGrammarParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(SurveyGrammarParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyGrammarParser#choiceID}.
	 * @param ctx the parse tree
	 */
	void enterChoiceID(SurveyGrammarParser.ChoiceIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyGrammarParser#choiceID}.
	 * @param ctx the parse tree
	 */
	void exitChoiceID(SurveyGrammarParser.ChoiceIDContext ctx);
}