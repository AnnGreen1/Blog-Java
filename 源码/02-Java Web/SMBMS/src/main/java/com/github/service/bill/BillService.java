package com.github.service.bill;

import com.github.pojo.Bill;

import java.sql.Connection;
import java.util.List;

/**
 * @Package: com.github.service.bill
 * @ClassName: BillService
 * @Author: subei
 * @CreateTime: 2021/8/15 10:18
 * @Description:
 */
public interface BillService {
    // ���Ӷ���
    public boolean add(Bill bill);

    // ͨ����ѯ������ȡ��Ӧ���б�-ģ����ѯ-getBillList
    public List<Bill> getBillList(Bill bill);

    //ͨ��delIdɾ��Bill
    public boolean deleteBillById(String delId);

    // ͨ��billId��ȡBill
    public Bill getBillById(String id);

    // �޸Ķ�����Ϣ
    public boolean modify(Bill bill);

}
