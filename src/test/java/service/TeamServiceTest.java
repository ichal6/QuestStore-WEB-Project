package service;

import DAO.TeamDAO;
import exception.ReadException;
import model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;

class TeamServiceTest {
    @InjectMocks
    TeamService teamService;

    @Mock
    TeamDAO teamDAO;

    @BeforeEach
    public void init() throws ReadException {
        MockitoAnnotations.initMocks(this);
        given(teamDAO.getAllTeams()).willReturn(prepareMockData());
    }

    @Test
    public void shouldGetUnsortedTeamsIfSortingParametersDontExist() throws ReadException {
        // given:
        String sortBy = null;
        Boolean order = null;
        List<Team> teamsListBeforeSort = prepareMockData();

        // when:
        List<Team> teamsListFromService = teamService.getAllTeams(sortBy, order);

        // then:
        Assertions.assertEquals(teamsListBeforeSort.get(0).getId(), teamsListFromService.get(0).getId());
        Assertions.assertEquals(teamsListBeforeSort.get(1).getId(), teamsListFromService.get(1).getId());
        Assertions.assertEquals(teamsListBeforeSort.get(2).getId(), teamsListFromService.get(2).getId());
    }

    private List<Team> prepareMockData() {
        Team team1 = new Team.Builder()
                .withID(97)
                .build();
        Team team2 = new Team.Builder()
                .withID(99)
                .build();
        Team team3 = new Team.Builder()
                .withID(94)
                .build();
        List<Team> teamsList = new ArrayList<>();
        teamsList.add(team1);
        teamsList.add(team2);
        teamsList.add(team3);

        return teamsList;
    }
}