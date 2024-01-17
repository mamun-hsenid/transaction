package com.hsenid.project.transaction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Long userId;

    @Column(name = "username")
    public String userName;

    @Column(name = "account_number")
    public Long accountNumber;

    @Column(name = "account_branch")
    public String accountBranch;

    @Column(name = "available_balance")
    public Long availableBalance;

    @Column(name = "contact")
    public String contact;

    @Column(name = "email")
    public String email;
}
