package eapli.base.app.backoffice.console.presentation.survey;


import eapli.base.surveymanagement.application.controller.ShowReportController;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.List;

public class ShowReportUI extends AbstractUI {

    private final ShowReportController controller = new ShowReportController();

    @Override
    protected boolean doShow() {
        List<SurveyDTO> list = controller.getSurveyList();
        SurveyDTO surveyDTO = (SurveyDTO) showAndSelectOne(list,"Choose the survey you want to see the report");

        int[] info = controller.getCommonInformation(surveyDTO.id);

        System.out.println("-Universe Size: "+info[0]);
        System.out.println("-Number of Responses Obtained: " + info[1]);
        double percentage = ((double) info[1] /info[0]) *100;
        System.out.printf("%% of responses obtained: %.0f%% \n",percentage);

        try{
            System.out.println(controller.getQuestionInfo());
        }catch (Exception e){
            System.out.println("There was an error processing the information");
        }


        return true;
    }

    @Override
    public String headline() {
        return "Show report";
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
