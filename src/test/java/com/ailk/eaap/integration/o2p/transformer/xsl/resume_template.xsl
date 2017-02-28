<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<!--��ģ�� -->
	<xsl:template match="/">
		<HTML>
			<HEAD>
				<TITLE>���˼���</TITLE>
			</HEAD>
			<BODY>
				<xsl:apply-templates select="document/resume" />
			</BODY>
		</HTML>
	</xsl:template>
	<!--����ģ�� -->
	<xsl:template match="resume">
		<TABLE border="1" cellspacing="0">
			<CAPTION></CAPTION>
			<xsl:apply-templates select="name" />
			<xsl:apply-templates select="sex" />
			<xsl:apply-templates select="birthday" />
			<TR />
			<TD>����</TD>
			<TD COLSPAN="5">
				<TABLE cellspacing="0">
					<xsl:apply-templates select="skill" />
				</TABLE>
			</TD>
		</TABLE>
		<BR />
	</xsl:template>
	<!--����ģ�� -->
	<xsl:template match="name">
		<TD>����</TD>
		<TD>
			<xsl:value-of />
		</TD>
	</xsl:template>
	<!--�Ա�ģ�� -->
	<xsl:template match="sex">
		<TD>�Ա�</TD>
		<TD>
			<xsl:value-of />
		</TD>
	</xsl:template>
	<!--����ģ�� -->
	<xsl:template match="birthday">
		<TD>����</TD>
		<TD>
			<xsl:value-of />
		</TD>
	</xsl:template>
	<!--����ģ�� -->
	<xsl:template match="skill">
		<TR>
			<TD>
				<xsl:value-of />
			</TD>
		</TR>
	</xsl:template>
</xsl:stylesheet>