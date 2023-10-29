package kr.ac.wku.listview_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.listview_20231029.adapters.StudentAdapter
import kr.ac.wku.listview_20231029.databinding.ActivityMainBinding
import kr.ac.wku.listview_20231029.datas.StudentData

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

    lateinit var mStudentAdapter: StudentAdapter

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //화면이 켜질때 학생목록을 ArrayList에 수기로 추가(임시활용)
        mStudentList.add(StudentData("김김김",1983,"010-1234-5678"))
        mStudentList.add(StudentData("김정은",1999,"010-2345-6789"))
        mStudentList.add(StudentData("바이든",2002,"010-3456-7890"))
        mStudentList.add(StudentData("김학생",2000,"010-4567-8901"))
        mStudentList.add(StudentData("대학생",1997,"010-5678-9012"))
        mStudentList.add(StudentData("머학생",1994,"010-6789-0123"))
        mStudentList.add(StudentData("전학생",2006,))

        //어탭터 변수도 객체 생성
        mStudentAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList )

        binding.studentListView.adapter = mStudentAdapter
    }
}