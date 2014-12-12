package com.example.uia.battlefree;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UnitDescriptionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class UnitDescriptionFragment extends Fragment{

    Button currOpen = null;

    String unitName;
    String unitAbilityName;
    String unitAbilityCost;

    TextView n;
    TextView an;
    TextView ac;

    public UnitDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit_description, container, false);


        n = (TextView) view.findViewById(R.id.unitName);
        an = (TextView) view.findViewById(R.id.unitAbilityName);
        ac = (TextView) view.findViewById(R.id.unitAbilityCost);

        setUnitDesc(unitName,unitAbilityName,unitAbilityCost);

        Button addButton = (Button) view.findViewById(R.id.addUnitButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ChooseUnits)getActivity()).addUnit(currOpen, unitName);
            }
        });
        return view;
    }


    public void setUnitDesc(String name, String aName, String aCost){
        n.setText(name);
        an.setText(aName);
        ac.setText(aCost);
    }

    public void setUnitName(String n){this.unitName = n;}
    public void setUnitAbilityName(String n){this.unitAbilityName = n;}
    public void setUnitAbilityCost(String n){this.unitAbilityCost = n;}

    public void setCurrOpen(Button b){
        this.currOpen = b;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
