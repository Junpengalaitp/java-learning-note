package com.junpenghe.solid.isp.before;

public class HPPrinterNScanner implements IMultiFunction {
    @Override
    public void print() {

    }

    @Override
    public void getPrintSpoolDetails() {

    }

    @Override
    public void scan() {

    }

    @Override
    public void scanPhoto() {

    }

    @Override
    public void fax() {
        System.out.println("error, do not support this function");
    }

    @Override
    public void internetFax() {
        System.out.println("error, do not support this function");
    }
}
