package ObjectsAndClasses_08.MoreExercises.TeamWorkProjects_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TWP_05 {
    static class Team {
        public String TeamName;
        public String CreatorName;
        public List<String> Members;

        public Team() {
        }

        public String getTeamName() {
            return TeamName;
        }

        public String getCreatorName() {
            return CreatorName;
        }

        public void setCreatorName(String creatorName) {
            CreatorName = creatorName;
        }

        public List<String> getMembers() {
            return Members;
        }

        public void setMembers(List<String> members) {
            Members = members;
        }

        public void setTeamName(String teamName) {
            TeamName = teamName;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Team> teams = new ArrayList<>();

        while (n-- > 0) {
            String[] newTeam = sc.nextLine().split("-");
            List<String> membersList = new ArrayList<>();
            Team team = new Team();

            team.TeamName = newTeam[1];
            team.CreatorName = newTeam[0];
            team.Members = membersList;

            teams.stream().filter(t -> !team.getTeamName().contains((newTeam[1]))).forEachOrdered(t -> {
                if (!team.getCreatorName().contains(newTeam[0])) {
                    teams.add(team);
                    System.out.printf("Team %s has been created by %s!%n", newTeam[1], newTeam[0]);
                } else {
                    System.out.printf("%s cannot create another team!%n", team.CreatorName);
                }
            });

            boolean match = teams.stream().anyMatch(t -> t.getTeamName().contains(newTeam[1]));
            System.out.printf("Team %s was already created!", team.TeamName);

            String line = sc.nextLine();

      /*  while (!line.equals("end of assignment")) {

            String[] tokens = line.split("->");
            String newUser = tokens[0];
            String teamName = tokens[1];
            if (!teams.Select(x => x.TeamName).Contains(teamName))
            {
                Console.WriteLine("Team {0} does not exist!", teamName);
            }
                else if (teams.Select(x => x.Members).Any(x => x.Contains(newUser)) || teams.Select(x => x.CreatorName).Contains(newUser))
            {
                Console.WriteLine("Member {0} cannot join team {1}!", newUser, teamName);
            }
                else
            {
                int teamToJoinIndex = teams.FindIndex(x => x.TeamName == teamName);
                teams[teamToJoinIndex].Members.Add(newUser);
            }

            teamRegistration = Console.ReadLine();
        }

        var teamsToDisband = teams.OrderBy(x => x.TeamName).Where(x => x.Members.Count == 0);
        var fullTeams = teams.
                OrderByDescending(x => x.Members.Count).
        ThenBy(x => x.TeamName).
        Where(x => x.Members.Count > 0);

        foreach (var team in fullTeams)
        {
            Console.WriteLine($"{team.TeamName}");
            Console.WriteLine($"- {team.CreatorName}");
            foreach (var member in team.Members.OrderBy(x => x))
            {
                Console.WriteLine($"-- {member}");
            }
        }

        Console.WriteLine("Teams to disband:");
        foreach (var item in teamsToDisband)
        {
            Console.WriteLine(item.TeamName);
        }

    }*/
        }
    }
}