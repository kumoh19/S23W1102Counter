package kr.ac.kumoh.ce.s20190467.s23w1102counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun onAdd(){
        _count.value = _count.value?.plus(1)
    }

    fun onSub(){
        if((_count.value ?: 0) > 0)   //?: 앨비스 연산자 value가 null이면 0으로 해라. !!써도 되는데 사용에 신중
            _count.value = _count.value?.minus(1)
    }
}