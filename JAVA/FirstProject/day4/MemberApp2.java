package com.example.day4;

public class MemberApp2 {
    public static void main(String[] args) {
        //5명의 member를 추가 (gener 2 , vip 2, vvip1)
        GeneralMember mem1 = new GeneralMember("user1", "A1");
        GeneralMember mem2 = new GeneralMember("user2", "B");
        VipMember mem3 = new VipMember("vip1", "S1");
        VipMember mem4 = new VipMember("vip2", "S2");
        VVipMember mem5 = new VVipMember("vvip1");

        //Array
        IMemberFunc[] members = new IMemberFunc[5];
        members[0] = mem1;
        members[1] = mem2;
        members[2] = mem3;
        members[3] = mem4;
        members[4] = mem5;

        for (IMemberFunc member : members) {
            member.setPoint(100);
            member.display();
        }

        Object[] obj = new Object[3];
        obj[0] = new GeneralMember("user1", "A1");
        obj[1] = new VipMember("user2", "v1");
        obj[1] = new VVipMember("user3");

        for (Object o : obj) {
            IMemberFunc member = null;
            if(o instanceof GeneralMember){
                member = (GeneralMember) o;
            }else if( o instanceof VipMember){
                member = (VipMember) o;
            }else  if(o instanceof  VVipMember){
                member = (VVipMember) o;
            }
            member.setPoint(100);
            member.display();
        }
    }
}
