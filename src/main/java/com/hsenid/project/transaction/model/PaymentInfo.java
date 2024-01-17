package com.hsenid.project.transaction.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "transaction_info")
public class PaymentInfo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "transaction_id", updatable = false, nullable = false)
    public String transactionId;

    @Column(name = "sender_account")
    public Long senderAccount;

    @Column(name = "receiver_account")
    public Long receiverAccount;

    @Column(name = "sender_branch")
    public String senderBranch;

    @Column(name = "receiver_branch")
    public String receiverBranch;

    @Column(name = "transaction_Amount")
    public Long transactionAmount;
}
