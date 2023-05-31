package eapli.base.surveymanagement.application.grammar;

import eapli.base.surveymanagement.application.grammar.ANTLR.SurveyGrammarBaseVisitor;
import eapli.base.surveymanagement.application.grammar.ANTLR.SurveyGrammarParser;
import eapli.base.surveymanagement.domain.*;

import javax.naming.SizeLimitExceededException;
import java.util.*;

public class SurveyVisitor extends SurveyGrammarBaseVisitor {


    Map<Integer, List<Question>> memory = new HashMap<>();
    List<Section> memorySections = new ArrayList<>();
    Integer controloQuestion = 0;
    Integer controloSection = 1;
    Integer num = 2;

    @Override
    public Survey visitQuestionario(SurveyGrammarParser.QuestionarioContext ctx){
        for(SurveyGrammarParser.SectionContext section : ctx.sectionList().section()){
            visitSeccao((SurveyGrammarParser.SeccaoContext) section);
        }
        Date data = Calendar.getInstance().getTime();
        Calendar cal =Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        data = cal.getTime();
        Survey survey = null;
        try {
            survey = new Survey(ctx.surveyID().getText(), data, ctx.title().getText(), ctx.welcomeMessage().getText(), "", memorySections);
        } catch (SizeLimitExceededException e) {
            e.printStackTrace();
        }
        return survey;
    }

    @Override
    public Integer visitQuestao(SurveyGrammarParser.QuestaoContext ctx){
        int variavel = Integer.parseInt(ctx.questionID().getText());
        if(controloQuestion>=variavel) {
            controloSection++;
        }
        controloQuestion = variavel;
        Question question = null;
        String[] la;
        List<String> le = new ArrayList<>();
        String[] li = ctx.type().getText().split("\r\n");
        switch(li[0]){
            case "free-text" :
                question = new Free_TextQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText());
                break;
            case "numeric" :
                question = new NumericQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText());
                break;
            case "single-choice" :
                la = ctx.type().getText().split("\r\n");
                for(int i = 0; i<la.length; i++)
                    le.add(la[i]);
                question = new SingleChoiceQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText(), le);
                break;
            case "single-choice with input value" :
                la = ctx.type().getText().split("\r\n");
                for(int i = 0; i<la.length; i++)
                    le.add(la[i]);
                question = new SingleChoiceWithInputQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText(), le);
                break;
            case "multiple-choice" :
                la = ctx.type().getText().split("\r\n");
                for(int i = 1; i<la.length; i++)
                    le.add(la[i]);
                question = new MultipleChoiceQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText(), le, num);
                break;
            case "multiple-choice with input value" :
                la = ctx.type().getText().split("\r\n");
                for(int i = 0; i<la.length; i++)
                    le.add(la[i]);
                question = new MultipleChoiceWithInputQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText(), le, num);
                break;
            case "sorting options" :
                la = ctx.type().getText().split("\r\n");
                for(int i = 0; i<la.length; i++)
                    le.add(la[i]);
                question = new SortingQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText(), le);
                break;
            case "scalling options" :
                la = ctx.type().getText().split("\r\n");
                for(int i = 0; i<la.length; i++)
                    le.add(la[i]);
                question = new ScalingQuestion(ctx.questionSentence().getText(), variavel, ctx.obligatoriness().getText(), le);
                break;
        }
        if(memory.get(controloSection)==null){
            memory.put(controloSection,new ArrayList<>());
            memory.get(controloSection).add(question);
        } else{
            memory.get(controloSection).add(question);
        }
        return null;
    }

    @Override
    public Integer visitSeccao(SurveyGrammarParser.SeccaoContext ctx) {
        for (SurveyGrammarParser.QuestionContext questao : ctx.content().question()){
            visitQuestao((SurveyGrammarParser.QuestaoContext) questao);
        }
        int variavel = Integer.parseInt(ctx.sectionID().getText());
        Section section = new Section(variavel, ctx.title().getText(), ctx.shortDescription().getText(), ctx.obligatoriness().getText(), "", memory.get(variavel));
        memorySections.add(section);
        return null;
    }

}
