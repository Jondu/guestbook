package ee.andmevara.service;

import ee.andmevara.dao.EntryDao;
import ee.andmevara.model.Comment;
import ee.andmevara.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryDao entryDao;

    public void addEntry(Entry entry) {
        entryDao.addEntry(entry);
    }

    public void addComment(Comment comment) {
        entryDao.addComment(comment);
    }

    public List<Entry> getAllEntries() {
        return entryDao.getEntry();
    }

}
