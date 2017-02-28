package com.ailk.eaap.integration.o2p.transformer.xml;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

import org.springframework.util.Assert;

import com.asiainfo.foundation.exception.BusinessException;

/**
 * 
 * @author 颖勤
 * 
 */
public class StringSource extends StreamSource {

	private final String content;

	/**
	 * Initializes a new instance of the <code>StringSource</code> with the
	 * given string content.
	 * 
	 * @param content
	 *            the content
	 */
	public StringSource(String content) {
		Assert.notNull(content, "'content' must not be null");
		this.content = content;
	}

	@Override
	public Reader getReader() {
		return new StringReader(content);
	}

	/**
	 * Throws {@link UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             always
	 */
	@Override
	public void setInputStream(InputStream inputStream) {
		throw new BusinessException(9147,
				"o2p.serviceAgent.transformer.stringSource.inputStream", null,
				null);
	}

	/**
	 * Returns {@code null}.
	 * 
	 * @return {@code null}
	 */
	@Override
	public InputStream getInputStream() {
		return null;
	}

	/**
	 * Throws {@link UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             always
	 */
	@Override
	public void setReader(Reader reader) {
		throw new BusinessException(9148,
				"o2p.serviceAgent.transformer.stringSource.reader", null, null);
	}

	@Override
	public String toString() {
		return content;
	}
}
