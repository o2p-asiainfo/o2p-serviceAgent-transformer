<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<!--根模板 -->
	<xsl:template match="/">
		<HTML>
			<HEAD>
				<TITLE>个人简历</TITLE>
			</HEAD>
			<BODY>
				<xsl:apply-templates select="document/resume" />
			</BODY>
		</HTML>
	</xsl:template>
	<!--简历模板 -->
	<xsl:template match="resume">
		<TABLE border="1" cellspacing="0">
			<CAPTION></CAPTION>
			<xsl:apply-templates select="name" />
			<xsl:apply-templates select="sex" />
			<xsl:apply-templates select="birthday" />
			<TR />
			<TD>技能</TD>
			<TD COLSPAN="5">
				<TABLE cellspacing="0">
					<xsl:apply-templates select="skill" />
				</TABLE>
			</TD>
		</TABLE>
		<BR />
	</xsl:template>
	<!--姓名模板 -->
	<xsl:template match="name">
		<TD>姓名</TD>
		<TD>
			<xsl:value-of />
		</TD>
	</xsl:template>
	<!--性别模板 -->
	<xsl:template match="sex">
		<TD>性别</TD>
		<TD>
			<xsl:value-of />
		</TD>
	</xsl:template>
	<!--生日模板 -->
	<xsl:template match="birthday">
		<TD>生日</TD>
		<TD>
			<xsl:value-of />
		</TD>
	</xsl:template>
	<!--技能模板 -->
	<xsl:template match="skill">
		<TR>
			<TD>
				<xsl:value-of />
			</TD>
		</TR>
	</xsl:template>
</xsl:stylesheet>