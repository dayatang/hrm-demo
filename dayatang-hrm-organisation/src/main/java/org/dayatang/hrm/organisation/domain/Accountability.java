package org.dayatang.hrm.organisation.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.dayatang.domain.AbstractEntity;
import org.dayatang.utils.DateUtils;

@Entity
@Table(name = "accountabilities")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
@NamedNativeQueries({
    @NamedNativeQuery(name = "Accountability.findAccountabilitiesByParty",
            query = "select o from Accountability o where (o.commissioner = :party or o.responsible = :party) and o.fromDate <= :date and o.toDate > :date")})
public abstract class Accountability<C extends Party, R extends Party> extends AbstractEntity {

    private static final long serialVersionUID = 3456398163374995470L;

    private C commissioner;

    private R responsible;

    private Date fromDate;

    private Date toDate;

<<<<<<< HEAD
    Accountability() {
=======
    protected Accountability() {
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f
    }

    public Accountability(C commissioner, R responsible, Date fromDate) {
        this.commissioner = commissioner;
        this.responsible = responsible;
<<<<<<< HEAD
        this.fromDate = fromDate;
=======
        this.fromDate = new Date(fromDate.getTime());
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f
        this.toDate = DateUtils.MAX_DATE;
    }

    @ManyToOne(targetEntity = Party.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "commissioner_id")
    public C getCommissioner() {
        return commissioner;
    }

<<<<<<< HEAD
    void setCommissioner(C commissioner) {
=======
    public void setCommissioner(C commissioner) {
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f
        this.commissioner = commissioner;
    }

    @ManyToOne(targetEntity = Party.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "responsible_id")
    public R getResponsible() {
        return responsible;
    }

<<<<<<< HEAD
    void setResponsible(R responsible) {
=======
    public void setResponsible(R responsible) {
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f
        this.responsible = responsible;
    }

    @Temporal(TemporalType.DATE)
<<<<<<< HEAD
    public Date getFromDate() {
        return fromDate;
=======
    @Column(name = "from_date")
    public Date getFromDate() {
        return new Date(fromDate.getTime());
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f
    }

    void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Temporal(TemporalType.DATE)
<<<<<<< HEAD
=======
    @Column(name = "to_date")
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f
    public Date getToDate() {
        return toDate;
    }

    void setToDate(Date toDate) {
        this.toDate = toDate;
    }

<<<<<<< HEAD
=======
    @Override
    public String[] businessKeys() {
        return new String[]{"commissioner", "responsible", "fromDate", "toDate"};
    }

>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f
    public void terminate(Date date) {
        this.toDate = date;
        save();
    }

    @SuppressWarnings("rawtypes")
    public static <T extends Accountability> List<T> findAccountabilities(Class<T> accountabilityClass, Date date) {
        return getRepository().createCriteriaQuery(accountabilityClass).le("fromDate", date).gt("toDate", date).list();
    }

    @SuppressWarnings("rawtypes")
    public static List<Accountability> findAccountabilitiesByParty(Party party, Date date) {
        return getRepository().createNamedQuery("Accountability.findAccountabilitiesByParty")
                .addParameter("party", party).addParameter("date", date).list();
    }

}
