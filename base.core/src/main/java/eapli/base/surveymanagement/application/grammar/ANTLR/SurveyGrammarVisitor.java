// Generated from C:/Users/Rita Lello/Documents/lei21_22_s4_2de_02/base.core/src/main/java/eapli/base/surveymanagement/application/grammar\SurveyGrammar.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.grammar.ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SurveyGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SurveyGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SurveyGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code questionario}
	 * labeled alternative in {@link SurveyGrammarParser#survey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionario(SurveyGrammarParser.QuestionarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#surveyID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSurveyID(SurveyGrammarParser.SurveyIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#alphanumeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlphanumeric(SurveyGrammarParser.AlphanumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(SurveyGrammarParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#welcomeMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWelcomeMessage(SurveyGrammarParser.WelcomeMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(SurveyGrammarParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#sectionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionList(SurveyGrammarParser.SectionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#finalMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalMessage(SurveyGrammarParser.FinalMessageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seccao}
	 * labeled alternative in {@link SurveyGrammarParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccao(SurveyGrammarParser.SeccaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#sectionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionID(SurveyGrammarParser.SectionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#shortDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortDescription(SurveyGrammarParser.ShortDescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#obligatoriness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatoriness(SurveyGrammarParser.ObligatorinessContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(SurveyGrammarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(SurveyGrammarParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code questao}
	 * labeled alternative in {@link SurveyGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestao(SurveyGrammarParser.QuestaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#questionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionID(SurveyGrammarParser.QuestionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#questionSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionSentence(SurveyGrammarParser.QuestionSentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SurveyGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#choices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoices(SurveyGrammarParser.ChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(SurveyGrammarParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyGrammarParser#choiceID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoiceID(SurveyGrammarParser.ChoiceIDContext ctx);
}