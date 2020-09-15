package com.DataStruct.Enum;

public class AccessControl {
    public static void main(String[] args) {
        AccessRight accessRight = AccessRight.valueOf("MANAGER");
        System.out.println(checkRight(accessRight));

    }
    public static boolean checkRight(AccessRight accessRight){
        if(accessRight == AccessRight.MANAGER)
            return true;
        else if(accessRight == AccessRight.DEPARTMENT)
            return false;
        return false;
    }
}

enum AccessRight{
    MANAGER, DEPARTMENT, EMPLOYEE
}
