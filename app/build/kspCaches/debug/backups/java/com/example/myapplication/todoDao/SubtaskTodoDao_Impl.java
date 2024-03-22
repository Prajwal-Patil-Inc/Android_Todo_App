package com.example.myapplication.todoDao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myapplication.todoEntities.SubtaskTodo;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SubtaskTodoDao_Impl implements SubtaskTodoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SubtaskTodo> __insertionAdapterOfSubtaskTodo;

  private final EntityDeletionOrUpdateAdapter<SubtaskTodo> __deletionAdapterOfSubtaskTodo;

  private final EntityDeletionOrUpdateAdapter<SubtaskTodo> __updateAdapterOfSubtaskTodo;

  private final SharedSQLiteStatement __preparedStmtOfSetFinished;

  public SubtaskTodoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSubtaskTodo = new EntityInsertionAdapter<SubtaskTodo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `subtasks` (`id`,`subtaskID`,`subtaskTitle`,`subtaskScheduledDate`,`subtaskScheduledTime`,`isSubtaskCompleted`) VALUES (?,nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SubtaskTodo value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSubtaskID());
        if (value.getSubtaskTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSubtaskTitle());
        }
        if (value.getSubtaskScheduledDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubtaskScheduledDate());
        }
        if (value.getSubtaskScheduledTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSubtaskScheduledTime());
        }
        final int _tmp = value.isSubtaskCompleted() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__deletionAdapterOfSubtaskTodo = new EntityDeletionOrUpdateAdapter<SubtaskTodo>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `subtasks` WHERE `subtaskID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SubtaskTodo value) {
        stmt.bindLong(1, value.getSubtaskID());
      }
    };
    this.__updateAdapterOfSubtaskTodo = new EntityDeletionOrUpdateAdapter<SubtaskTodo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `subtasks` SET `id` = ?,`subtaskID` = ?,`subtaskTitle` = ?,`subtaskScheduledDate` = ?,`subtaskScheduledTime` = ?,`isSubtaskCompleted` = ? WHERE `subtaskID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SubtaskTodo value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSubtaskID());
        if (value.getSubtaskTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSubtaskTitle());
        }
        if (value.getSubtaskScheduledDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubtaskScheduledDate());
        }
        if (value.getSubtaskScheduledTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSubtaskScheduledTime());
        }
        final int _tmp = value.isSubtaskCompleted() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getSubtaskID());
      }
    };
    this.__preparedStmtOfSetFinished = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update subtasks set isSubtaskCompleted = ? where id = ? AND subtaskID = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertSubtask(final SubtaskTodo subtaskTodo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSubtaskTodo.insert(subtaskTodo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final SubtaskTodo subtaskTodo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSubtaskTodo.handle(subtaskTodo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final SubtaskTodo subtaskTodo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSubtaskTodo.handle(subtaskTodo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object setFinished(final long id, final long subtaskID, final boolean isFinished,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfSetFinished.acquire();
        int _argIndex = 1;
        final int _tmp = isFinished ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, subtaskID);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfSetFinished.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<SubtaskTodo>> getAllSubtasks() {
    final String _sql = "SELECT * FROM subtasks";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"subtasks"}, new Callable<List<SubtaskTodo>>() {
      @Override
      public List<SubtaskTodo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubtaskID = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskID");
          final int _cursorIndexOfSubtaskTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskTitle");
          final int _cursorIndexOfSubtaskScheduledDate = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskScheduledDate");
          final int _cursorIndexOfSubtaskScheduledTime = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskScheduledTime");
          final int _cursorIndexOfIsSubtaskCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isSubtaskCompleted");
          final List<SubtaskTodo> _result = new ArrayList<SubtaskTodo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SubtaskTodo _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpSubtaskID;
            _tmpSubtaskID = _cursor.getLong(_cursorIndexOfSubtaskID);
            final String _tmpSubtaskTitle;
            if (_cursor.isNull(_cursorIndexOfSubtaskTitle)) {
              _tmpSubtaskTitle = null;
            } else {
              _tmpSubtaskTitle = _cursor.getString(_cursorIndexOfSubtaskTitle);
            }
            final String _tmpSubtaskScheduledDate;
            if (_cursor.isNull(_cursorIndexOfSubtaskScheduledDate)) {
              _tmpSubtaskScheduledDate = null;
            } else {
              _tmpSubtaskScheduledDate = _cursor.getString(_cursorIndexOfSubtaskScheduledDate);
            }
            final String _tmpSubtaskScheduledTime;
            if (_cursor.isNull(_cursorIndexOfSubtaskScheduledTime)) {
              _tmpSubtaskScheduledTime = null;
            } else {
              _tmpSubtaskScheduledTime = _cursor.getString(_cursorIndexOfSubtaskScheduledTime);
            }
            final boolean _tmpIsSubtaskCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSubtaskCompleted);
            _tmpIsSubtaskCompleted = _tmp != 0;
            _item = new SubtaskTodo(_tmpId,_tmpSubtaskID,_tmpSubtaskTitle,_tmpSubtaskScheduledDate,_tmpSubtaskScheduledTime,_tmpIsSubtaskCompleted);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<SubtaskTodo>> getSubtasksById(final long id) {
    final String _sql = "SELECT * FROM subtasks WHERE id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"subtasks"}, new Callable<List<SubtaskTodo>>() {
      @Override
      public List<SubtaskTodo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubtaskID = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskID");
          final int _cursorIndexOfSubtaskTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskTitle");
          final int _cursorIndexOfSubtaskScheduledDate = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskScheduledDate");
          final int _cursorIndexOfSubtaskScheduledTime = CursorUtil.getColumnIndexOrThrow(_cursor, "subtaskScheduledTime");
          final int _cursorIndexOfIsSubtaskCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isSubtaskCompleted");
          final List<SubtaskTodo> _result = new ArrayList<SubtaskTodo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SubtaskTodo _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpSubtaskID;
            _tmpSubtaskID = _cursor.getLong(_cursorIndexOfSubtaskID);
            final String _tmpSubtaskTitle;
            if (_cursor.isNull(_cursorIndexOfSubtaskTitle)) {
              _tmpSubtaskTitle = null;
            } else {
              _tmpSubtaskTitle = _cursor.getString(_cursorIndexOfSubtaskTitle);
            }
            final String _tmpSubtaskScheduledDate;
            if (_cursor.isNull(_cursorIndexOfSubtaskScheduledDate)) {
              _tmpSubtaskScheduledDate = null;
            } else {
              _tmpSubtaskScheduledDate = _cursor.getString(_cursorIndexOfSubtaskScheduledDate);
            }
            final String _tmpSubtaskScheduledTime;
            if (_cursor.isNull(_cursorIndexOfSubtaskScheduledTime)) {
              _tmpSubtaskScheduledTime = null;
            } else {
              _tmpSubtaskScheduledTime = _cursor.getString(_cursorIndexOfSubtaskScheduledTime);
            }
            final boolean _tmpIsSubtaskCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSubtaskCompleted);
            _tmpIsSubtaskCompleted = _tmp != 0;
            _item = new SubtaskTodo(_tmpId,_tmpSubtaskID,_tmpSubtaskTitle,_tmpSubtaskScheduledDate,_tmpSubtaskScheduledTime,_tmpIsSubtaskCompleted);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
