package org.dayatang.hrm.organisation.domain;

import org.dayatang.domain.ValueObject;

import javax.persistence.Embeddable;

/**
 * Created by yyang on 14-3-5.
 */
@Embeddable
public class Address implements ValueObject {
    private String province;
    private String city;
    private String detail;

    public Address(String province, String city, String detail) {
        this.province = province;
        this.city = city;
        this.detail = detail;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDetail() {
        return detail;
    }
}
