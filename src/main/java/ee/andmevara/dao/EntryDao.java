package ee.andmevara.dao;

import ee.andmevara.model.Comment;
import ee.andmevara.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Repository
public class EntryDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public List<Entry> getEntry() {
        return jdbcTemplate.query("SELECT guestbook_entry.id," +
                        "guestbook_entry.username as name," +
                        "guestbook_entry.entry as entry," +
                        "array_agg(guestbook_comment.comment) as comments" +
                        " FROM guestbook_entry " +
                        " LEFT JOIN guestbook_comment ON guestbook_comment.entry_id = guestbook_entry.id " +
                        " GROUP BY guestbook_entry.id",
                (rs, rowNum) -> {
                    Entry entry = new Entry();
                    Array a = rs.getArray("comments");
                    String[] comments = (String[]) a.getArray();
                    entry.setEntry(rs.getString("entry"));
                    entry.setName(rs.getString("name"));
                    entry.setId(rs.getLong("id"));
                    entry.setComments(Arrays.asList(comments));
                    return entry;
                }
        );
    }


    public void addEntry(Entry entry) {
        jdbcTemplate.update(
                "INSERT INTO guestbook_entry (entry, username) VALUES (?,?) ",
                entry.getEntry(),
                entry.getName()
        );
    }

    public void addComment(Comment comment) {
        jdbcTemplate.update(
                "INSERT INTO guestbook_comment (entry_id, comment) VALUES (?,?) ",
                comment.getEntryId(),
                comment.getComment()
        );
    }
}
