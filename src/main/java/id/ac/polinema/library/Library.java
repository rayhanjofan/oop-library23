
package id.ac.polinema.library;

import java.util.Arrays;
import java.util.Locale;

public class Library {

    private String name;
    private LibraryItem[] items;
    private int itemCount;
    private Member[] members;
    private int memberCount;

    public Library(String name) {
        this.name = name;
        this.items = new LibraryItem[20];
        this.itemCount = 0;
        this.members = new Member[10];
        this.memberCount = 0;
    }

    public String getName() {
        return name;
    }

    public boolean addItem(LibraryItem item) {
        if (item == null || itemCount >= items.length) {
            return false;
        }

        items[itemCount] = item;
        itemCount++;
        return true;
    }

    public boolean addMember(Member member) {
        if (member == null
                || memberCount >= members.length
                || findMember(member.getMemberId()) != null) {
            return false;
        }

        members[memberCount] = member;
        memberCount++;
        return true;
    }

    public LibraryItem[] getItems() {
        return Arrays.copyOf(items, itemCount);
    }

    public Member[] getMembers() {
        return Arrays.copyOf(members, memberCount);
    }

    public LibraryItem findItemByTitle(String title) {
        if (title == null) {
            return null;
        }

        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title)) {
                return items[i];
            }
        }

        return null;
    }

    public Member findMember(String memberId) {
        if (memberId == null) {
            return null;
        }

        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }

        return null;
    }

    public LibraryItem[] searchByKeyword(String keyword) {
        if (keyword == null) {
            return new LibraryItem[0];
        }

        String search = keyword.toLowerCase(Locale.ROOT);
        LibraryItem[] matches = new LibraryItem[itemCount];
        int matchCount = 0;

        for (int i = 0; i < itemCount; i++) {
            String title = items[i].getTitle().toLowerCase(Locale.ROOT);

            if (title.contains(search)) {
                matches[matchCount] = items[i];
                matchCount++;
            }
        }

        return Arrays.copyOf(matches, matchCount);
    }

    public boolean lend(String memberId, String title) {
        Member member = findMember(memberId);
        LibraryItem item = findItemByTitle(title);

        if (member == null
                || item == null
                || !member.canBorrow()
                || !item.isAvailable()) {
            return false;
        }

        if (!item.checkOut()) {
            return false;
        }

        if (!member.addLoan()) {
            item.returnItem();
            return false;
        }

        return true;
    }

    public boolean receive(String memberId, String title) {
        Member member = findMember(memberId);
        LibraryItem item = findItemByTitle(title);

        if (member == null
                || item == null
                || item.isAvailable()
                || member.getLoanCount() <= 0) {
            return false;
        }

        item.returnItem();

        if (!member.returnLoan()) {
            item.checkOut();
            return false;
        }

        return true;
    }
}
