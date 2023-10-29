package kr.ac.wku.listview_20231029.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.ac.wku.listview_20231029.R
import kr.ac.wku.listview_20231029.datas.StudentData

class StudentAdapter(
    mContext: Context,
    resId: Int,
    val mList: ArrayList<StudentData>   //getView "함수"에서도 사용하고 싶다 : val 키워드 추가 -> 멤버변수로 등록
) : ArrayAdapter<StudentData>(mContext, resId, mList) { //ArrayAdapter: //기본생성자 지원 X

    //커스텀으로 만든 xml을 -> 코틀린단으로 끌어와주는 객체

    val inf = LayoutInflater.from(mContext)

    //완성한 inf를 이용해서 -> xml을 가져와주는 함수
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //tempRow 역할 : 리스트뷰의 재샤용성에서 나오는 null 가능성을 대비하기 위한 임시 변수
        var tempRow = convertView

        //tempRow가 null상태라면 (재사용할 row가 아직 안 그려짐)
        if (tempRow == null){
            //xml을 -> inflate해서 (그려줌) -> tempRow에 담아준다.
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        //if문 빠져나온 후  : 원래 null이면? -> 새로 그려서 넣어줌. null아니면? 있는것 활용
        //tempRow에 null상태일 가능성 제거

        //진짜 사용할 row변수에, tempRow가 절대 null 아니라고 우기면서 대입
        val row = tempRow!!

        //xml을 그려낸 row 객체 내부에서, 텍스트뷰 등을 찾아서 실제 데이터로 연동
        //실제 데이터? 어떤 학생 => mList의 position에 맞는 객체

        val stdData = mList[position]   //그림을 그려줄 위치에 맞는 학생객체 추출

        //row안의 이름 표시하는 TextView를 변수로 가져와야, stdData의 이름 값을 대입 가능
        //Adapter에서는 데이터 바인딩 사용 불가 -> 직접 코드로 불러내야 함 (텍스트뷰들 가져오기)

        val txtName = row.findViewById<TextView>(R.id.txtName)
        val txtPhoneNum = row.findViewById<TextView>(R.id.txtPhoneNum)
        val txtAge = row.findViewById<TextView>(R.id.txtAge)

        txtName.text = stdData.name
        txtPhoneNum.text = stdData.phoneNum
        txtAge.text = "${stdData.getKoreanAge(2023)}세"



        return row
    }
}