package pluralsight.ddd.practice.event;

import pluralsight.ddd.practice.management.HeadOffice;

public class BalanceChangedEventHandler implements Handler<BalanceChangedEvent> {
    @Override
    public void handle(BalanceChangedEvent domainEvent) {
//        Repository com.junpenghe.spring.spring.data.repository = new HeadOfficeRepository();
        HeadOffice headOffice = new HeadOffice();
//        headOffice.changeBalance(domainEvent.getDelta());
//        com.junpenghe.spring.spring.data.repository.save(headOffice);
    }
}
