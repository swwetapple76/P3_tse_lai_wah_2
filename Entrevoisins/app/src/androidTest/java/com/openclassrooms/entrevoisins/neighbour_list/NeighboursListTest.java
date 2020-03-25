
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;
    private NeighbourApiService mServices;
    private static int POSITION_ITEM = 0;
    private List<Neighbour> mNeighbourList = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    // Test 1
    /*test vérifiant que lorsqu’on clique sur un élément de la liste,
    l’écran de détails est bien lancé ;*/
    @Test
    public void click_item_to_ListDetailNeighbourActivity(){

        String ITEM_NAME= "Caroline";

        onView(allOf(withId(R.id.list_neighbours),isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));

        onView(withId(R.id.activity_detail_neighbour)).check(matches(isDisplayed()));

        onView(allOf(withId(R.id.person_name),isDisplayed())).check(matches(withText(ITEM_NAME)));
    }

    //Test 2
    /*test vérifiant qu’au démarrage de ce nouvel écran, le TextView indiquant le nom de
    l’utilisateur en question est bien rempli ;*/
    @Test
    public void listDetailNeighbourActivity_name_isDisplay() {
        //Given : create a neighbour for test at the position 0
        Neighbour neighbour = this.mNeighbourList.get(POSITION_ITEM);
        //When : click on a item of neighbour list at position 0
       onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.activity_detail_neighbour))
                .check(matches(isDisplayed()));

        onView(withId(R.id.person_name))
                .check(matches(withText(neighbour.getName())));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    //Test 3
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT))
                .perform(actionOnItemAtPosition(2, new DeleteViewAction()));

        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT - 1));
    }

    // Test 4
    /*test vérifiant que l’onglet Favoris n’affiche que les voisins marqués comme
    favoris.*/
    @Test
    public void favoriteNeighbourList_should_show_only_favouriteList() {

        onView(withContentDescription("Favorites")).perform(click());

        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(3));
    }

}