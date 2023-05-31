package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.agv.application.AssignOrderController;
import eapli.base.agv.dto.AGVDTO;
import eapli.base.order.dto.Product_OrderDTOComplete;
import eapli.base.surveymanagement.application.controller.RegisterSurveyController;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.dto.SectionDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegisterSurveyUI extends AbstractUI {

    private final RegisterSurveyController controller = new RegisterSurveyController();

    private final List<String> questionTypes = List.of(new String[]{"Free Text", "Numeric", "SingleChoice", "SingleChoiceWithInput","MultipleChoice","MultipleChoiceWithInput","Sorting","Scaling"});
    private final List<String> sectionObligation = List.of(new String[]{"Mandatory", "Optional", "Conditional dependent"});
    private final List<String> option = List.of(new String[]{"Using a file", "Manually creating a survey"});
    private final List<String> condition = List.of(new String[]{"Age", "Gender","No condition"});
    private final List<String> gender = List.of(new String[]{"female", "male","other"});

    @Override
    protected boolean doShow() {
        String str = (String) showAndSelectOne(option,"Do you want to create an survey using a file or manually inserting the data");
        if (str.equals("Using a file")){
            try {
                String file = Console.readLine("Enter the file path");
                String la = condition();
                controller.registerSurvey(file, la);
                //ler ficheiro

                System.out.println("Survey created with success");
                return true;
            }catch (IOException e){
                System.out.println("It occurred an error opening the file");
                return true;
            }catch (Exception e){
                System.out.println("The survey in the file is invalid and couldn't create the survey");
                return true;
            }
        }


        String id = Console.readLine("Enter the survey id");

        int num_dias = Console.readInteger("Enter the number of days you want to be able to perform the survey");

        Date data = Calendar.getInstance().getTime();
        Calendar cal =Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH,num_dias);
        data = cal.getTime();

        String title = Console.readLine("Enter the title of the survey");
        String welcome_message = Console.readLine("Enter the welcome message");

        boolean flagsection = true;
        int sectionId = 0;
        int questionId=0;
        List<SectionDTO> sectionDTOList = new ArrayList<>();
        List<Question> questionList = new ArrayList<>();
        List<Integer> num_questions = new ArrayList<>();

        while (flagsection){
            sectionId++;
            String sectiontitle = Console.readLine("Enter the section title");
            String sectiondescription = Console.readLine("Enter the section description");
            String sectionobli = (String) showAndSelectOne(sectionObligation,"Choose an obligation");
            String section_condition = "";
            if (sectionobli.equals("Conditional dependent") ){
                section_condition = Console.readLine("Enter the condition");
            }
            sectionDTOList.add(new SectionDTO(sectionId,sectiontitle,sectiondescription,sectionobli,section_condition));
            int num_question=0;
            boolean flagquestion =true;
            while (flagquestion){
                questionId++;
                String question = Console.readLine("Enter the question");
                String question_type = (String) showAndSelectOne(questionTypes,"Choose the type of question");

                List<String> answerlist ;
                switch (question_type){
                    case "Free Text":
                        questionList.add(new Free_TextQuestion(question,questionId,question_type));
                        break;
                    case "Numeric":
                        questionList.add(new NumericQuestion(question,questionId,question_type));
                        break;
                    case "SingleChoice":
                        answerlist = new ArrayList<>();
                        do {
                            String answer = Console.readLine("Write an possible answer");
                            answerlist.add(answer);
                        }while (confirms("Do you want to add more answers?"));
                        questionList.add(new SingleChoiceQuestion(question,questionId,question_type,answerlist));
                        break;
                    case "SingleChoiceWithInput":
                        answerlist = new ArrayList<>();
                        do {
                            String answer = Console.readLine("Write an possible answer");
                            answerlist.add(answer);
                        }while (confirms("Do you want to add more answers?"));
                        questionList.add(new SingleChoiceWithInputQuestion(question,questionId,question_type,answerlist));
                        break;
                    case "MultipleChoice":
                        answerlist = new ArrayList<>();
                        do {
                            String answer = Console.readLine("Write an possible answer");
                            answerlist.add(answer);
                        }while (confirms("Do you want to add more answers?"));
                        int maxChoices = Console.readInteger("Enter the maximum number of choices");
                        questionList.add(new MultipleChoiceQuestion(question,questionId,question_type,answerlist,maxChoices));
                        break;
                    case "MultipleChoiceWithInput":
                        answerlist = new ArrayList<>();
                        do {
                            String answer = Console.readLine("Write an possible answer");
                            answerlist.add(answer);
                        }while (confirms("Do you want to add more answers?"));
                        int maxChoicess = Console.readInteger("Enter the maximum number of choices");
                        questionList.add(new MultipleChoiceWithInputQuestion(question,questionId,question_type,answerlist,maxChoicess));
                        break;
                    case "Sorting":
                    case "Scaling":
                        answerlist = new ArrayList<>();
                        do {
                            String answer = Console.readLine("Write an possible answer");
                            answerlist.add(answer);
                        }while (confirms("Do you want to add more answers?"));
                        break;
                }
                num_question++;
                if (!confirms("Do you want to add another question?")){
                    flagquestion = false;
                }
            }
            num_questions.add(num_question);

            if (!confirms("Do you want to add another section?")){
                flagsection = false;
            }
        }


        String la = condition();

        try {
            controller.registerSurvey(id,data,title,welcome_message,la,num_questions,sectionDTOList,questionList);
            System.out.println("Survey created with success");
        } catch (SizeLimitExceededException e) {
            System.out.println("It occurred an error creating an survey");
        }


        return true;
    }

    private String condition() {
        String la = (String) showAndSelectOne(condition,"Select a condition you want to put in the survey");
        switch (la){
            case "Age":
                la += ";" + Console.readInteger("Type the minimum age the customer must have");
                break;
            case "Gender":
                la += ";" + showAndSelectOne(gender,"Choose the gender the customer must have");
                break;
            case "No condition":
                la += ";";
        }
        return la;
    }

    @Override
    public String headline() {
        return "Assign an order";
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
