package eapli.base.app.common.console.presentation.authz;

import eapli.base.surveymanagement.application.controller.QuestionnaireListController;
import eapli.base.surveymanagement.domain.*;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionnaireListUI extends AbstractUI {

    private final QuestionnaireListController controller = new QuestionnaireListController();

    private Role onlyWithThis;

    public QuestionnaireListUI(final Role onlyWithThis) {
        this.onlyWithThis = onlyWithThis;
    }

    @Override
    protected boolean doShow() {
        try {
            List<Survey> questionnairesList = controller.getQuestionnairesList();
            if (questionnairesList.isEmpty()){
                System.out.println("There are no surveys for you to respond");
                return true;
            }
            String answer;
            /*
            do{
                System.out.println("Choose the survey you want to answer.");
                System.out.println("0- None.");
                for(int i = 0; i< questionnairesList.size(); i++)
                    System.out.println(i+1+"- "+ questionnairesList.get(i));
                option = Console.readInteger("Option: ");
            } while(option<0);
             */
            Survey choosenSurvey = (Survey) showAndSelectOne(questionnairesList,"Choose the survey you want to answer.");
            if (choosenSurvey == null){
                return true;
            }
            //Survey choosenSurvey = questionnairesList.get(option-1);
            Map<Question, String> answers = new HashMap<>();
            String value;
            String header;
            int num;
            boolean exit;
            String junto = "";
            boolean responder=true;
            for(Section section: choosenSurvey.sectionsList()){
                if(section.obligatoriness().equalsIgnoreCase("optional")){
                    System.out.println(section);
                    responder=confirms("Want to answer this section?");
                } else if(section.obligatoriness().equalsIgnoreCase("mandatory")){
                    responder = true;
                } else{
                    String[] aux = section.obligatoriness().split(" ");
                    List<Section> list = choosenSurvey.sectionsList();

                    int numaux1 = Integer.parseInt(aux[2]) -1;
                    int numaux2 = Integer.parseInt(aux[3]) -1;
                    Question la = list.get(numaux1).questionList().get(numaux2);

                    char help =  aux[4].charAt(0);
                    if(answers.get(la).equals(la.answerlist().get(help - 97))){
                        responder = true;
                    }else {
                        responder = false;
                    }


                }
                if(responder==true){
                    for(Question question: section.questionList()){
                        responder = true;
                        if(question.obligatoriness().equalsIgnoreCase("optional")){
                            System.out.println(question);
                            responder=confirms("Want to answer this question?");
                        } else if(section.obligatoriness().equalsIgnoreCase("mandatory")){
                            responder = true;
                        } else{
                            String[] aux = question.obligatoriness().split(" ");
                            List<Section> list = choosenSurvey.sectionsList();


                            int numaux1 = Integer.parseInt(aux[2]) -1;
                            int numaux2 = Integer.parseInt(aux[3]) -1;
                            Question la = list.get(numaux1).questionList().get(numaux2);

                            char help =  aux[4].charAt(0);
                            if(answers.containsKey(la) && answers.get(la).equals(la.answerlist().get(help -97))){
                                responder = true;
                            }else {
                                responder = false;
                            }


                        }

                        if (responder == true) {


                            if (question.type().equalsIgnoreCase("free-text") || question.type().equalsIgnoreCase("numeric")) {
                                System.out.println(question);
                                answer = Console.readLine("Answer: ");
                                answers.put(question, answer);
                            } else if (question.type().equalsIgnoreCase("single-choice")) {
                                //SingleChoiceQuestion question1 = (SingleChoiceQuestion) question;
                                List<String> list = question.answerlist();
                                list.remove(question.type());
                                answer = (String) showAndSelectOne(list, "Choose one choice: ");
                                answers.put(question, answer);
                            } else if (question.type().equalsIgnoreCase("single-choice with input value")) {
                                //SingleChoiceWithInputQuestion question2 = (SingleChoiceWithInputQuestion) question;
                                List<String> list = question.answerlist();
                                list.remove(question.type());
                                answer = (String) showAndSelectOne(list, "Choose one choice: ");
                                value = Console.readLine("Input value: ");
                                answer = answer + value;
                                answers.put(question, answer);
                            } else if (question.type().equalsIgnoreCase("multiple-choice")) {
                                //MultipleChoiceQuestion question3 = (MultipleChoiceQuestion) question;
                                //num = question3.num_max_choices();
                                num = 2;
                                List<String> list = question.answerlist();
                                list.remove(question.type());
                                junto = "";
                                do {
                                    header = "Choose " + num + " choice(s) maximum: ";
                                    answer = (String) showAndSelectOne(list, header);
                                    junto += answer;
                                    exit = !confirms("Want to choose another choice?");
                                    num--;
                                } while (exit == false && num > 0);
                                answers.put(question, junto);
                            } else if (question.type().equalsIgnoreCase("multiple-choice with input value")) {
                                //MultipleChoiceWithInputQuestion question4 = (MultipleChoiceWithInputQuestion) question;
                                //num = question4.num_max_choices();
                                num = 2;
                                List<String> list = question.answerlist();
                                list.remove(question.type());
                                junto="";
                                do {
                                    header = "Choose " + num + " choice(s) maximum: ";
                                    answer = (String) showAndSelectOne(list, header);
                                    junto += answer;
                                    exit = !confirms("Want to choose another choice?");
                                    num--;
                                } while (exit == false && num > 0);
                                value = Console.readLine("Input value: ");
                                junto = junto + value;
                                answers.put(question, junto);
                            } else if (question.type().equalsIgnoreCase("scalling options")) {
                                //ScalingQuestion question5 = (ScalingQuestion) question;
                                List<String> list = question.answerlist();
                                list.remove(question.type());
                                answer = (String) showAndSelectOne(list, "Choose one choice: ");
                                answers.put(question, answer);
                            } else if (question.type().equalsIgnoreCase("sorting options")) {
                                //SortingQuestion question6 = (SortingQuestion) question;
                                num = question.answerlist().size() -1;
                                List<String> list2 = question.answerlist();
                                list2.remove(question.type());
                                junto = "";
                                do {
                                    header = "Choose the choice: (" + num + " to go)";
                                    answer = (String) showAndSelectOne(list2, header);
                                    list2.remove(answer);
                                    junto += answer;
                                    num--;
                                } while (num > 0);
                                answers.put(question, junto.replace(".",";"));
                            }
                        }
                    }
                }
            }
            controller.answerSurvey(choosenSurvey, answers);
            System.out.println("Survey Answered.");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Answer questionnaire";
    }

    private Object showAndSelectOne(List list, String header)
    {
        showList(list,header);
        return selectsObject(list);
    }

    private Object selectsObject(List list)
    {
        String input;
        Integer value;
        do
        {
            input = Console.readLine("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0)
        {
            return null;
        } else
        {
            return list.get(value - 1);
        }
    }

    private boolean confirms(String message){
        String str;
        do {
            str = Console.readLine("\n" + message + "\n");
        } while (!str.equalsIgnoreCase("s") && !str.equalsIgnoreCase("n"));

        return str.equalsIgnoreCase("s");
    }

    private void showList(List list, String header)
    {
        System.out.println(header);

        int index = 0;
        for (Object o : list)
        {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancel");
    }
}
