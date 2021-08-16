package com.github.dao.bill;

import com.github.pojo.Bill;

import java.sql.Connection;
import java.util.List;

/**
 * @Package: com.github.dao.bill
 * @ClassName: BillDao
 * @Author: subei
 * @CreateTime: 2021/8/15 10:01
 * @Description:
 */
public interface BillDao {
    // ���Ӷ���
    public int add(Connection connection, Bill bill)throws Exception;

    // ͨ����ѯ������ȡ��Ӧ���б�-ģ����ѯ-getBillList
    public List<Bill> getBillList(Connection connection, Bill bill)throws Exception;

    //ͨ��delIdɾ��Bill
    public int deleteBillById(Connection connection, String delId)throws Exception;

    // ͨ��billId��ȡBill
    public Bill getBillById(Connection connection, String id)throws Exception;

    // �޸Ķ�����Ϣ
    public int modify(Connection connection, Bill bill)throws Exception;

    // ���ݹ�Ӧ��ID��ѯ��������
    public int getBillCountByProviderId(Connection connection, String providerId)throws Exception;

}
