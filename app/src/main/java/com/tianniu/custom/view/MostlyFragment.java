package com.tianniu.custom.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianniu.custom.HttpCallBack;
import com.tianniu.custom.HttpManager;
import com.tianniu.custom.OpApplication;
import com.tianniu.custom.adapter.ViewHolder;
import com.tianniu.custom.api.CargoApi;
import com.tianniu.custom.model.OrderInfo;
import com.tianniu.custom.model.PersonInfo;
import com.tianniu.custom.model.QueryInfo;
import com.tianniu.custom.view.base.BaseFragment;
import com.tianniu.up.testprogect.R;
import com.zhy.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;


public class MostlyFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MostlyFragment() {
        // Required empty public constructor
    }


    public static MostlyFragment newInstance(String param1, String param2) {
        MostlyFragment fragment = new MostlyFragment();
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {
        setHasOptionsMenu(true);
    }


    @Override
    public void initListener() {

    }


    @Override
    public void initData() {
        if (getActivity() == null)
            return;
        OpApplication applicationInfo = (OpApplication)getActivity().getApplication();
        PersonInfo personInfo = applicationInfo.getPersonInfo();
        CargoApi cargoApi = HttpManager.getInstance().get(CargoApi.class);

        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setUserId(personInfo.getId());
        queryInfo.setTicket(personInfo.getTicket());
        queryInfo.setStartCoord("440.18,4424.29");
        queryInfo.setStartLonLat("116.3,39.95");
        queryInfo.setStartDistance("500");
        queryInfo.setQueryType(1);

        cargoApi.searchCargo(HttpManager.getInstance().searchCargo(queryInfo)).enqueue(new HttpCallBack<List<OrderInfo>>(getActivity()) {
            @Override
            public void onSuccess(List<OrderInfo> orderInfos) {
                if (orderInfos != null){
                    String taskContent = orderInfos.get(1).getTaskContent();
                }
            }
        });

    }

    @Override
    public void processClick(View view) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_oostly, container, false);
        RecyclerView rvCargo = (RecyclerView) rootview.findViewById(R.id.recyclerView_cargo_content);
        rvCargo.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setNickName("测试"+i);
            orderInfos.add(orderInfo);
        }

//        rvCargo.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        rvCargo.setAdapter(new CommonAdapter<OrderInfo>(getContext(),R.layout.item_rv_cargo,orderInfos) {
            @Override
            protected void convert(com.zhy.adapter.recyclerview.base.ViewHolder holder, OrderInfo orderInfo, int position) {
                TextView tv_cargo_explan = holder.getView(R.id.tv_cargo_explan);
                tv_cargo_explan.setText(orderInfo.getNickName());
            }
        });



        // Inflate the layout for this fragment
        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

    }


}
