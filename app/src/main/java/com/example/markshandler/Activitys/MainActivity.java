package com.example.markshandler.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.markshandler.Adapters.Adapteruser;
import com.example.markshandler.Models.modeluser;
import com.example.markshandler.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView ;
    ArrayList<modeluser> list = new ArrayList<>();
    Adapteruser adapter ;
    public static String subjectName  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch (Login.semester) {

            case "first":
                First();
                break;

            case "second":
                Second();
                break;

            case "third":
                Third();
                break;

            case "fourth":
                Fourth();
                break;

            case "fifth":
                Fifth();
                break;

            case "sixth":
                Sixth();
                break;

            case "seventh":
                Seventh();
                break;

            case "eighth":
                Eighth();
                break;

            default:
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

        }


    }

    public void First(){
        String [] subject = {"مقدمة فى الحاسبات" , "مبادئ رياضة" , "مبادئ إحصاء", "لغة انجليزية(1)", "نظم تشغيل الحاسبات", "دراسات بيئية" , "لغة عربية و تطبيقاتها" , "أصول تربية"};
        String [] doctor = {"د/محمد السيد عبدالعظيم" , "د/محى الدين علامى" , "د/وسام كمال" , "د/فاطمة عبده" , "د/عطا الالفى" , "د/ابراهيم إبراهيم أحمد" , "د/ أحمد عبدالقدير" , "د/الهلالي الشربيني"};

        listView = findViewById(R.id.list_view_user);

        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }


        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    public void Second(){
        String [] subject = {"قواعد البيانات" , "رياضيات حاسب" , "مقدمة في البرمجة" , "مقدمة في النوافذ" , "تكنولوجيا المعلومات" , "لغة انجليزية (2)" , "مبادئ علم النفس" , "حقوق إنسان"};
        String [] doctor = {"د/حنان الرفاعي" , "د/سها شعيب" , "د/مروة حسين" , "د/إيمان عبدالعظيم العياط" , "د/مروة حسين" , "د/فاطمة عبده" , "د/إبراهيم إبراهيم أحمد" , ""};

        listView = findViewById(R.id.list_view_user);
        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }

        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    public void Third(){
        String [] subject = {"برمجة (1)" , "نظم تشغيل حاسبات (2)" , "تحليل نظم" , "معالجة النصوص" , "لغة انجليزية و تطبيقاتها (1)" , "مبادىء تدريس" , "علم النفس النمو"};
        String [] doctor = {"د/أمانى فوزي الجمل" , "د/عطا الألفي" , "د/أمانى عبدالعزيز" , "د/منى عصمت" , "د/فاطمة عبده" , "د/ فاطمة عبده" , "د/مروة الششتاوي"};

        listView = findViewById(R.id.list_view_user);

        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }
        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    public void Fourth(){
        String [] subject = {"برمجة (2)" , "تصميم نظم" , "قواعد بيانات (2)" , "صيانة الحاسب الآلي" , "لغة إنجليزية و تطبيقاتها(2)" , "التربية و مشكلات المجتمع" , "الوسائل التعليمية"};
        String [] doctor = {"د/ رانيا عدلي" , "د/ شيماء خاطر" , "د/ أحمد عبدالبديع" , "د/منى عصمت" , "د/فاطمة عبده" , "د/أمانى غبور" , "د/محمد فوزي"};

        listView = findViewById(R.id.list_view_user);

        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }
        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    public void Fifth(){
        String [] subject = {"منظمة الحاسب الآلي" , "الحاسب الآلي و أمن البيانات" , "علم النفس الإجتماعي" , "الأصول الإجتماعية للتربية" , "طرق تدريس (1)" , "إستخدام الجداول الإلكترونية" , "الإحصاء و الحاسب"};
        String [] doctor = {"د/محي الدين إسماعيل" , "د/ نبيل عبدالمحسن" , "د/ عبدالله جاد " , "د/الهلالي الشربيني" , "د/عاصم البحيري" , "د/إيمان عبدالقادر" , "د/وسام كمال"};

        listView = findViewById(R.id.list_view_user);

        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }
        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    public void Sixth(){
        String [] subject = {"الذكاء الإصطناعي " , "الوسائط المتعددة" , "البرمجة الجاهزة(1)" , "تاريخ التربية والتعليم" , "علاقات أسرية" , "علم نفس تعليمي " , "تطبيقات الحاسب الآلي "};
        String [] doctor = {"د/عطا الألفي" , "د/أحمد عبدالبديع" , "د/ أماني فوزي الجمل" , "د/حنان رزق" , "د/إبراهيم إبراهيم أحمد" , "د/أحمد البهيي" , "د/أحمد أمين"};

        listView = findViewById(R.id.list_view_user);

        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }
        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    public void Seventh(){
        String [] subject = {"النظم الخبيرة" , "البرمجة الجاهزة (2)" , "تطبيقات الحاسب الألي (2)" , "الشبكات العالمية" , "تربية مقارنة" , "طرق تدريس (2)" , "علم النفس التعليمي"};
        String [] doctor = {"د/عطا الألفي" , "د/حسنية محمد" , "د/أحمد أمين" , "د/محي الدين إسماعيل" , "د/حنان رزق" , "د/عاصم البحيري" , "د/أحمد البهيي"};

        listView = findViewById(R.id.list_view_user);

        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }
        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    public void Eighth(){
        String [] subject = {"طرق تخطيط البرامج" , "شبكات الحاسب الآلي" , "النظم المعاونة في إتخاذ القرار" , "البرمجة الشيئية والهيكلية" , "الأصول الفلسفية للتربية" , "المناهج" , "صحة نفسية وإرشاد"};
        String [] doctor = {"د/حنان الرفاعي" , "د/محي الدين إسماعيل" , "د/منى عصمت" , "د/حسنية محمد" , "د/الهلالي الشربيني" , "د/عاصم البحيري" , "د/عبدالله جاد"};

        listView = findViewById(R.id.list_view_user);

        for(int i = 0 ; i <subject.length;i++){

            list.add(new modeluser(subject[i], doctor[i]));
        }

        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

        listView.setAdapter(adapter);
        listViewClick();
    }


    private void listViewClick() {


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //news and events
                if (position == 0) {
                    Intent go = new Intent(MainActivity.this, SubjectDetilsActivity.class);
                    startActivity(go);
                    finish();

                }
                //about us
                else if (position == 1) {
                    startActivity(new Intent(MainActivity.this, SubjectDetilsActivity.class));
                    finish();

                }
            }
        });



    }

    public void logout(View view){

        Intent i =new Intent(MainActivity.this,Login.class);
        startActivity(i);
    }

}

