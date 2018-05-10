package com.practise.hibernate.data.entities;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by pratik on 10-05-2018.
 */
@Entity
@Table(name = "TIME_TEST")
public class TimeTest {

    @Id
    @GeneratedValue
    @Column(name = "TIME_TEST_ID")
    private Long timeTestId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME_COLUMN")
    private Date datetimeColumn;

    @Column(name = "TIMESTAMP_COLUMN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampColumn;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COLUMN")
    private Date dateColumn;

    @Temporal(TemporalType.TIME)
    @Column(name = "TIME_COLUMN")
    private Date timeColumn;

    @Column(name = "SQL_DATETIME_COLUMN")
    private java.sql.Timestamp sqlDatetimeColumn;

    @Column(name = "SQL_TIMESTAMP_COLUMN")
    private java.sql.Timestamp sqlTimestampColumn;

    @Column(name = "SQL_DATE_COLUMN")
    private java.sql.Date sqlDateColumn;

    @Column(name = "SQL_TIME_COLUMN")
    private java.sql.Time sqlTimeColumn;

    public TimeTest(Date date) {
        this.datetimeColumn = date;
        this.timestampColumn = date;
        this.dateColumn = date;
        this.timeColumn = date;

        this.sqlDatetimeColumn = new java.sql.Timestamp(date.getTime());
        this.sqlTimestampColumn = new java.sql.Timestamp(date.getTime());
        this.sqlDateColumn = new java.sql.Date(date.getTime());
        this.sqlTimeColumn = new java.sql.Time(date.getTime());
    }

    @Override
    public String toString() {
        return "TimeTest{" +
                "timeTestId=" + timeTestId +
                ", datetimeColumn=" + datetimeColumn +
                ", timestampColumn=" + timestampColumn +
                ", dateColumn=" + dateColumn +
                ", timeColumn=" + timeColumn +
                ", sqlDatetimeColumn=" + sqlDatetimeColumn +
                ", sqlTimestampColumn=" + sqlTimestampColumn +
                ", sqlDateColumn=" + sqlDateColumn +
                ", sqlTimeColumn=" + sqlTimeColumn +
                '}';
    }

    public Long getTimeTestId() {
        return timeTestId;
    }

    public void setTimeTestId(Long timeTestId) {
        this.timeTestId = timeTestId;
    }

    public Date getDatetimeColumn() {
        return datetimeColumn;
    }

    public void setDatetimeColumn(Date datetimeColumn) {
        this.datetimeColumn = datetimeColumn;
    }

    public Date getTimestampColumn() {
        return timestampColumn;
    }

    public void setTimestampColumn(Date timestampColumn) {
        this.timestampColumn = timestampColumn;
    }

    public Date getDateColumn() {
        return dateColumn;
    }

    public void setDateColumn(Date dateColumn) {
        this.dateColumn = dateColumn;
    }

    public Date getTimeColumn() {
        return timeColumn;
    }

    public void setTimeColumn(Date timeColumn) {
        this.timeColumn = timeColumn;
    }

    public Timestamp getSqlDatetimeColumn() {
        return sqlDatetimeColumn;
    }

    public void setSqlDatetimeColumn(Timestamp sqlDatetimeColumn) {
        this.sqlDatetimeColumn = sqlDatetimeColumn;
    }

    public Timestamp getSqlTimestampColumn() {
        return sqlTimestampColumn;
    }

    public void setSqlTimestampColumn(Timestamp sqlTimestampColumn) {
        this.sqlTimestampColumn = sqlTimestampColumn;
    }

    public java.sql.Date getSqlDateColumn() {
        return sqlDateColumn;
    }

    public void setSqlDateColumn(java.sql.Date sqlDateColumn) {
        this.sqlDateColumn = sqlDateColumn;
    }

    public Time getSqlTimeColumn() {
        return sqlTimeColumn;
    }

    public void setSqlTimeColumn(Time sqlTimeColumn) {
        this.sqlTimeColumn = sqlTimeColumn;
    }
}
