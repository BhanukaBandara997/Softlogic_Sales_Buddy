package softlogic_dealer_app.com.softlogic_dealer_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.adapter.RankedSalesAdapter;
import softlogic_dealer_app.com.softlogic_dealer_app.model.RankedSalesPerson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected final String[] parties = new String[]{
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };
    private PieData data;
    private TextView categories_txt, ranking_txt;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayout categorical_layout, leader_board_layout;
    private PieChart chart;
    private RecyclerView recyclerView;
    private RankedSalesAdapter adapter;
    private List<RankedSalesPerson> rankedSalesPersonList;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Sales Summary");
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        chart = view.findViewById(R.id.pieChart);
        categories_txt = view.findViewById(R.id.categories_txt);
        ranking_txt = view.findViewById(R.id.ranking_txt);
        categorical_layout = view.findViewById(R.id.categorical_layout);
        leader_board_layout = view.findViewById(R.id.leader_board_layout);


        categories_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categorical_layout.setVisibility(View.VISIBLE);
                leader_board_layout.setVisibility(View.GONE);
                categories_txt.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlue));
                ranking_txt.setTextColor(ContextCompat.getColor(getContext(), R.color.colorDarkGrey));
            }
        });

        ranking_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leader_board_layout.setVisibility(View.VISIBLE);
                categorical_layout.setVisibility(View.GONE);
                ranking_txt.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlue));
                categories_txt.setTextColor(ContextCompat.getColor(getContext(), R.color.colorDarkGrey));

            }
        });

        // Chart View
        chart.animateY(1400, Easing.EaseInOutQuad);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);

        chart.setDrawMarkers(false); // To remove markers when click
        chart.setDrawEntryLabels(false); // To remove labels from piece of pie
        chart.getDescription().setEnabled(false); // To remove description of pie
        setData(10, 50);

        recyclerView = view.findViewById(R.id.rank_list_recycler_view);

        rankedSalesPersonList = new ArrayList<>();
        adapter = new RankedSalesAdapter(getActivity(), rankedSalesPersonList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        addRankedSalesPersonsToList();

        return view;
    }

    private void setData(int count, float range) {

        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) (Math.random() * range) + range / 5, parties[i % parties.length]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setDrawValues(false);
        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        chart.setData(data);

        // undo all highlight
        chart.highlightValues(null);
        chart.invalidate();
    }

    /**
     * Adding Ranked Sales Persons To List
     */
    private void addRankedSalesPersonsToList() {
        int[] covers = new int[]{
                R.drawable.personal_user};

        RankedSalesPerson a = new RankedSalesPerson(1, "Felicity Lloyd", covers[0], "Dinapala-Piliyandala", 60);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(2, "Sama Dudley", covers[0], "Dinapala-Colombo", 40);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(3, "Smith Will", covers[0], "Dinapala-Kandy", 35);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(4, "Smith Will", covers[0], "Dinapala-Colombo", 30);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(5, "Smith Will", covers[0], "Dinapala-Wellawatte", 25);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(6, "Smith Will", covers[0], "Dinapala-Colombo", 25);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(7, "Smith Will", covers[0], "Dinapala-Colombo", 15);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(8, "Smith Will", covers[0], "Dinapala-Colombo", 10);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(9, "Smith Will", covers[0], "Dinapala-Colombo", 5);
        rankedSalesPersonList.add(a);

        a = new RankedSalesPerson(10, "Smith Will", covers[0], "Dinapala-Dehiwala", 2);
        rankedSalesPersonList.add(a);

        adapter.notifyDataSetChanged();
    }


}
