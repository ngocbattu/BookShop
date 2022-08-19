package com.example.bookshop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookshop.Adapter.AdapterChuyenAnh;
import com.example.bookshop.Adapter.AdapterSanPham;
import com.example.bookshop.Database.SanPhamDatabase;
import com.example.bookshop.Model.AnhQuangCao;
import com.example.bookshop.Model.SanPham;
import com.example.bookshop.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class TrangChuFragment extends Fragment {

    ViewPager mViewPager;
    ArrayList<AnhQuangCao> arrayList;
    AdapterChuyenAnh adapterChuyenAnh;
    Timer mTimer;
    RecyclerView mRecyclerView;
    AdapterSanPham adapterSanPham;
    List<SanPham> list;

    public TrangChuFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trang_c_h_u, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recy_view_trang_chu);
        mViewPager = view.findViewById(R.id.view_page);
        InserSanPham();
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        list = SanPhamDatabase.getInstance(getContext()).sanPhamDao().getSanPham();
        adapterSanPham = new AdapterSanPham(getContext(),list);
        mRecyclerView.setAdapter(adapterSanPham);
        arrayList = new ArrayList<> ();
        arrayList.add (new AnhQuangCao (1,R.drawable.anh_qc1));
        arrayList.add (new AnhQuangCao (2,R.drawable.anh_qc2));
        arrayList.add (new AnhQuangCao (3,R.drawable.anh_qc3));
        arrayList.add (new AnhQuangCao (4,R.drawable.anh_qc4));
        arrayList.add (new AnhQuangCao (5,R.drawable.anh_qc5));
        adapterChuyenAnh = new AdapterChuyenAnh(getContext(),arrayList);
        mViewPager.setAdapter(adapterChuyenAnh);
        AotuSlideImage();
    }
    private void AotuSlideImage() {
        if(arrayList == null || arrayList.isEmpty () || mViewPager == null){
            return;
        }
        if(mTimer == null){
            mTimer = new Timer ();
        }
        mTimer.schedule (new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper ()).post (new Runnable () {
                    @Override
                    public void run() {
                        int index_anh = mViewPager.getCurrentItem ();
                        int int_list_image = arrayList.size () - 1;
                        if(index_anh < int_list_image){
                            index_anh++;
                            mViewPager.setCurrentItem (index_anh);
                        }else {
                            mViewPager.setCurrentItem (0);
                        }
                    }
                });
            }
        },6000,6000);
    }

    public void InserSanPham(){
        SanPhamDatabase.getInstance(getContext()).sanPhamDao().
                InsetSanPham(new SanPham(1,R.drawable.sach1,"Napoleon Hill",200000,"Cách Nghĩ Để Thành Công mang tới cho bạn triết lý thành đạt, đồng thời cung cấp phương pháp để bạn lên kế hoạch chi tiết để đạt được thành công đó. Không chỉ có lý thuyết suông, tác phẩm này được dẫn chứng từ những trường hợp thực tế, ví dụ như Edison - nhà phát minh lỗi lạc, Henry Ford - ông trùm của nền công nghiệp xe hơi,... Napoleon Hill, tác giả của Cách Nghĩ Để Thành Công, đã dành ra 30 năm để phỏng vấn hơn 500 người thành công trong nhiều lĩnh vực khác nhau, từ đó đúc kết lại những triết lý và viết nên tác phẩm này."));
        SanPhamDatabase.getInstance(getContext()).sanPhamDao().InsetSanPham(new SanPham(2,R.drawable.sach2,"Hạt giống tâm hồn",150000,"Bộ sách hạt giống tâm hồn là bộ sách được tổng hợp các câu chuyện, bức tranh đầy ý nghĩa về cuộc sống của nhiều tác giả khác nhau. Đó là những câu chuyện về sự thành công, tấm lòng cao đẹp giữa con người với con người. Bộ sách giúp nuôi dưỡng cho bạn có một tâm hồn đẹp, trong sáng, luôn vui tươi và lạc quan."));
        SanPhamDatabase.getInstance(getContext()).sanPhamDao().InsetSanPham(new SanPham(3,R.drawable.sach3,"Dale Carnegie",300000,"Sau Đắc Nhân Tâm, Quẳng Gánh Lo Đi Và Vui Sống là tác phẩm nổi tiếng tiếp theo của Dale Carnegie. Cuốn sách này phân tích và giải đáp những nỗi buồn, lo lắng diễn ra hàng ngày trong cuộc sống của mỗi người. Để từ đó tác giả xây dựng nên thái độ sống tích cực, hạnh phúc và từ bỏ thói quen lo lắng. Tác phẩm được chia thành 6 phần, có thể xem mỗi phần là 1 lời khuyên hữu ích cho những ai đang gặp rắc rối và không biết phải làm thế nào để vượt qua vấn đề đó. Đây là quyển sách mà ai cũng nên đọc 1 lần trong đời, để giúp bản thân luôn vui vẻ và tích cực để vượt qua khó khăn."));
        SanPhamDatabase.getInstance(getContext()).sanPhamDao().InsetSanPham(new SanPham(4,R.drawable.sach4,"David J.Lieberman",60000,"Đọc Vị Bất Kỳ Ai là một quyển cẩm nang dạy bạn cách thâm nhập vào tâm trí của người khác, để suy đoán được họ đang nghĩ gì. Cuốn sách có nội dung bao gồm 2 phần chính và được chia thành 15 chương. Đọc Vị Bất Kỳ Ai sẽ là sự lựa chọn phù hợp cho những ai đang tìm kiếm một quyển sách để cải thiện và phát triển kỹ năng giao tiếp."));
        SanPhamDatabase.getInstance(getContext()).sanPhamDao().InsetSanPham(new SanPham(5,R.drawable.sach5,"Mario Puzo",80000,"Bố Già - có tên tiếng Anh là The Godfather, là cuốn sách hay kinh điển của Mario Puzo được xuất bản vào năm 1969. Nội dung của quyển sách xoay quanh một gia đình mafia gốc Ý với nhân vật chính là ông trùm Vito Corleone. Điểm nhấn của Bố Già nằm ở chỗ tuy nội dung viết về mafia, nhưng tác giả lại không bàn nhiều về ma túy hay cờ bạc, mà lại xoáy sâu vào những biến cố của gia đình đó và cách họ ứng biến với thử thách. Người làm nên nghiệp lớn, giúp gia đình vượt qua khó khăn và lên kế hoạch cho mọi thứ, người đó chính là Bố Già. Với cốt truyện kịch tính, gay cấn với nhiều tình tiết bất ngờ, Bố Già xứng đáng là một trong những cuốn sách hay nên đọc một lần trong đời."));
        SanPhamDatabase.getInstance(getContext()).sanPhamDao().InsetSanPham(new SanPham(6,R.drawable.sach6,"Cuộc sống không giới hạn",90000,"Tác giả Nick Vujicic đã khắc họa thành công câu chuyện kỳ diệu của chính bản thân mình thông qua Cuộc sống không giới hạn. Một chàng trai không lành lặn như bao người khác nhưng luôn có một tâm hồn, ý chí kiên cường vượt qua mọi chông gai và thử thách. Như tác giả đã từng nói:\n" +
                "“Bạn đẹp đẽ và quý giá hơn tất cả những viên kim cương trên thế gian này. Dẫu vậy, chúng ta nên luôn luôn đặt ra cho mình mục tiêu trở thành những con người tốt hơn, toàn thiện hơn, đẩy lùi và loại bỏ những giới hạn bằng cách mơ những giấc mơ lớn lao. Trong hành trình đó, chúng ta luôn cần có những điều chỉnh (bởi vì cuộc đời này không phải lúc nào cũng toàn là màu hồng), nhưng cuộc đời này luôn đáng sống. Tôi đến đây để nói với bạn rằng cho dù bạn đang ở trong hoàn cảnh nào, miễn là bạn còn thở, thì bạn vẫn có thể đóng góp cho cuộc đời này…”"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mTimer != null ){
            mTimer.cancel ();
            mTimer = null;
        }
    }
}