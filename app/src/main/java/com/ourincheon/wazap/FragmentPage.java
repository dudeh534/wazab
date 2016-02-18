package com.ourincheon.wazap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Youngdo on 2016-02-02.
 */
public class FragmentPage extends Fragment {

    private static final String ARG_POSITION = "position";
    RecyclerView content;
    LinearLayout linearLayout;
    private DataStorage storage = new DataStorage();
    private int position;

    public static FragmentPage newInstance(int position) {
        FragmentPage f = new FragmentPage();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        switch (position) {
            case 0:
                Log.e("position", String.valueOf(storage.getInstance().getPosition()));
                linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_page, container, false);
                content = (RecyclerView) linearLayout.findViewById(R.id.recyclerView);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                content.setHasFixedSize(true);
                content.setLayoutManager(layoutManager);
                List<Recycler_item> items = new ArrayList<>();
                Recycler_item[] item = new Recycler_item[5];
                item[0] = new Recycler_item("공개 소프트 웨어 공모대전", "채영도", "개발자");
                item[1] = new Recycler_item("대학생 마케팅 아이디어 공모전", "채영도", "개발자");
                item[2] = new Recycler_item("스타트업뱅크 리포트 오디션", "채영도", "개발자");
                item[3] = new Recycler_item("스타트업뱅크 리포트 오디션", "채영도", "개발자");
                item[4] = new Recycler_item("스타트업뱅크 리포트 오디션", "채영도", "개발자");

                for (int i = 0; i < 5; i++) items.add(item[i]);
                content.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), content, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent Iteminfo = new Intent(getActivity(), ItemInfoActivity.class);
                        Iteminfo.putExtra("position", position);
                        startActivity(Iteminfo);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                }));
                content.setAdapter(new RecyclerAdapter(getActivity(), items, R.layout.fragment_page));
                linearLayout.removeAllViews();
                linearLayout.addView(content);
                return linearLayout;
            case 1:
                Log.e("position", String.valueOf(storage.getInstance().getPosition()));
                linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_page, container, false);
                content = (RecyclerView) linearLayout.findViewById(R.id.recyclerView);
                LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
                content.setHasFixedSize(true);
                content.setLayoutManager(layoutManager2);
                List<Recycler_item> items2 = new ArrayList<>();
                Recycler_item[] item2 = new Recycler_item[5];
                item2[0] = new Recycler_item("스타트업 브라더 창업지업 프로그램 5차 모집", "마케팅", "2016-01-25 ~ 2016-02-22");
                item2[1] = new Recycler_item("[해외] 제9회 iPhone 사진공모전", "사진/영상/UCC, 해외", "2016-02-16 ~ 2016-03-31");

                for (int i = 0; i < 2; i++) items2.add(item2[i]);
                content.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), content, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String link;
                        if(position==0)
                            link="http://www.brother-korea.com";
                        else
                            link="http://www.ippawards.com/the-competition/";

                        Intent intent = new Intent(getActivity(), WebSiteActivity.class);
                        intent.putExtra("url", link);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                }));
                content.setAdapter(new RecyclerAdapter(getActivity(), items2, R.layout.fragment_page));
                linearLayout.removeAllViews();
                linearLayout.addView(content);
                return linearLayout;
                /*
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

                FrameLayout fl = new FrameLayout(getActivity());
                fl.setLayoutParams(params);

                final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
                        .getDisplayMetrics());

                TextView v = new TextView(getActivity());
                params.setMargins(margin, margin, margin, margin);
                v.setLayoutParams(params);
                v.setLayoutParams(params);
                v.setGravity(Gravity.CENTER);
                v.setBackgroundResource(R.drawable.background_card);
                v.setText("준비 중 입니다...");

                fl.addView(v);
                return fl;
                */
            default:
                return null;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}