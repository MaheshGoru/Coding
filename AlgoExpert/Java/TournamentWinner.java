import java.util.*;
class TournmentWinner{
    public static void main(String args[]){
        List<List<String>> competitions = Arrays.asList(Arrays.asList("HTML","C#"), Arrays.asList("C#","Python"),Arrays.asList("Python","HTML"));
        List<Integer> results = Arrays.asList(0,0,1);
        String winner = tournamentWinner(competitions, results);
        System.out.println(winner);
    }
    public static String tournamentWinner(List<List<String>> competitions, List<Integer> results){
        Map<String, Integer> teamPoints = new HashMap<>();
        for(int i=0;i<competitions.size();i++){
            String winner = results.get(i) == 0 ? competitions.get(i).get(1) : competitions.get(i).get(0);
            if(!teamPoints.containsKey(winner)){
                teamPoints.put(winner, 0);
            }
            teamPoints.put(winner, teamPoints.get(winner) + 3);
        }
        int maxScore = 0;
        String maxScoreTeam = "";
        for(Map.Entry<String, Integer> entry: teamPoints.entrySet()){
            if(entry.getValue() > maxScore){
                maxScore = entry.getValue();
                maxScoreTeam = entry.getKey();
            }
        }
        return maxScoreTeam;
    }
}