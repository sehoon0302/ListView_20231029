package kr.ac.wku.listview_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        //만들어진 어뎁터를 리스트뷰의 어뎁터로 연결
        binding.studentListView.adapter = mStudentAdapter

        //한명의 학생을 클릭하면 -> 토스트로 "이름: 연락처" 토스트로 출력
        binding.studentListView.setOnItemClickListener { adapterView, view, positon, l ->
            //이 함수의 세번째 (i, position) 변수 -> 클릭 된 위치를 알려주는 역할
            //mStudentList 중에서 클릭된 위치에 맞는 학생 추출 -> 활용

            val clickedStd = mStudentList[positon]

            Toast.makeText(this, "${clickedStd.name} : ${clickedStd.phoneNum}", Toast.LENGTH_SHORT).show()
        }

        //한명의 학생을 오래 클릭하면 -> 해당학생 삭제
        binding.studentListView.setOnItemLongClickListener { adapterView, view, positon, l ->
            //오래 클릭된 학생 -> (목록에서) 삭제
            mStudentList.removeAt(positon)  //내용물 변경 발생

            //어뎁터에게 통보
            mStudentAdapter.notifyDataSetChanged()

            //LongClick 이벤트는 Bool 타입의 리턴값을 받도록 되어있음.

            return@setOnItemLongClickListener true
        }
    }
}