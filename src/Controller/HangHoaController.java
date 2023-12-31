package Controller;

import Model.HangHoa;

public class HangHoaController {
    private HangHoa hanghoa;

    public HangHoaController(HangHoa hanghoa){
        this.hanghoa = hanghoa;
    }

    public void getAllHangHoa(){
        HangHoa.getHanghoas().toArray_A();
    }
}
