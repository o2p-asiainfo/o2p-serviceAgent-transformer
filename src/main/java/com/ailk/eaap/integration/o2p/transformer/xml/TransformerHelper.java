package com.ailk.eaap.integration.o2p.transformer.xml;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.springframework.util.Assert;

import com.asiainfo.foundation.exception.BusinessException;

/**
 * 
 * @author 颖勤
 * 
 */
public class TransformerHelper
{
    private volatile TransformerFactory transformerFactory;

    private Class<? extends TransformerFactory> transformerFactoryClass;

    /**
     * Initializes a new instance of the {@code TransformerHelper}.
     */
    public TransformerHelper()
    {
    }

    /**
     * Initializes a new instance of the {@code TransformerHelper} with the
     * specified {@link TransformerFactory}.
     */
    public TransformerHelper(TransformerFactory transformerFactory)
    {
        this.transformerFactory = transformerFactory;
    }

    /**
     * Initializes a new instance of the {@code TransformerHelper} with the
     * specified {@link TransformerFactory} class.
     */
    public TransformerHelper(
            Class<? extends TransformerFactory> transformerFactoryClass)
    {
        setTransformerFactoryClass(transformerFactoryClass);
    }

    /**
     * Specify the {@code TransformerFactory} class to use.
     */
    public void setTransformerFactoryClass(
            Class<? extends TransformerFactory> transformerFactoryClass)
    {
        Assert.isAssignable(TransformerFactory.class, transformerFactoryClass);
        this.transformerFactoryClass = transformerFactoryClass;
    }

    /**
     * Instantiate a new TransformerFactory.
     * The default implementation simply calls
     * {@link TransformerFactory#newInstance()}. If a
     * {@link #setTransformerFactoryClass transformerFactoryClass} has been
     * specified explicitly, the default constructor of the specified class will
     * be called instead.
     * Can be overridden in subclasses.
     * 
     * @param transformerFactoryClass
     *            the specified factory class (if any)
     * @return the new TransactionFactory instance
     *  #setTransformerFactoryClass
     *  #getTransformerFactory()
     */
    protected TransformerFactory newTransformerFactory(
            Class<? extends TransformerFactory> transformerFactoryClass)
    {
        if (transformerFactoryClass != null)
        {
            try
            {
                return transformerFactoryClass.newInstance();
            }
            catch (Exception ex)
            {
                String[] msgArgs =
                { transformerFactoryClass.toString() };
                throw new BusinessException(
                        9148,
                        "o2p.serviceAgent.transformer.transformerHelper.transformerFactory",
                        msgArgs, ex);
            }
        }
        else
        {
            return TransformerFactory.newInstance();
        }
    }

    /**
     * Returns the {@code TransformerFactory}.
     * 
     * @return the transformer factory
     */
    public TransformerFactory getTransformerFactory()
    {
        TransformerFactory result = transformerFactory;
        if (result == null)
        {
            result = newTransformerFactory(transformerFactoryClass);
            transformerFactory = result;
        }
        return result;
    }

    /**
     * Creates a new {@code Transformer}. Must be called per thread, as
     * transformers are not thread-safe.
     * 
     * @return the created transformer
     * @throws TransformerConfigurationException
     *             if thrown by JAXP methods
     */
    public Transformer createTransformer()
            throws TransformerConfigurationException
    {
        return getTransformerFactory().newTransformer();
    }

    /**
     * Creates a new {@code Transformer}. Must be called per thread, as
     * transformers are not thread-safe.
     * 
     * @param styleSource
     * @return the created transformer
     * @throws TransformerConfigurationException
     *             if thrown by JAXP methods
     */
    public Transformer createTransformer(Source styleSource)
            throws TransformerConfigurationException
    {
        return getTransformerFactory().newTransformer();
    }

    /**
     * Transforms the given {@link Source} to the given {@link Result}. Creates
     * a new {@link Transformer} for every call, as transformers are not
     * thread-safe.
     * 
     * @param source
     *            the source to transform from
     * @param result
     *            the result to transform to
     * @throws TransformerException
     *             if thrown by JAXP methods
     */
    public void transform(Source source, Result result)
            throws TransformerException
    {
        Transformer transformer = createTransformer();
        transformer.transform(source, result);
    }
}
