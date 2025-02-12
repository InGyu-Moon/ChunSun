package com.chunsun.couponkafkaservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import com.chunsun.couponkafkaservice.common.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member_coupon")
public class MemberCoupon extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint NOT NULL AUTO_INCREMENT")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "coupon_id",
		nullable = false,
		foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
	)
	private Coupon coupon;

	@Column(name = "member_id", nullable = false, columnDefinition = "bigint NOT NULL")
	private Long memberId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status",
		nullable = false,
		columnDefinition = "enum('UNUSED','USED','EXPIRED') NOT NULL DEFAULT 'UNUSED'")
	private CouponStatus status;

	@Column(name = "expiry_date", nullable = false, columnDefinition = "datetime NOT NULL")
	private LocalDateTime expiryDate;

	public void changeStatusToExpired() {
		this.status = CouponStatus.EXPIRED;
	}
}
