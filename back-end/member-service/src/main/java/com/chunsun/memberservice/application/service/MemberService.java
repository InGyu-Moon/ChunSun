package com.chunsun.memberservice.application.service;

import org.springframework.data.domain.Page;

import com.chunsun.memberservice.application.dto.MemberDto;

public interface MemberService {

	MemberDto.SignUpResponse signUp(MemberDto.SignUpRequest request);

	MemberDto.UpdateInfoResponse updateMemberInfo(Long id, MemberDto.UpdateInfoRequest request);

	MemberDto.GetInfoResponse getMemberInfo(Long id);

	void deleteMember(Long id);

	void checkNicknameAvailability(String nickname);

	Boolean isDeleted(Long memberId);

	Page<MemberDto.MemberListItem> getFilterMembers(String category, String gender, String age, int page, int size, Long userId);

}
