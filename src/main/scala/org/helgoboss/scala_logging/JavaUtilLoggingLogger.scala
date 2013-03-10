/**
 * The MIT License
 *
 * Copyright (c) 2011 Benjamin Klum
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.helgoboss.scala_logging

import java.util.logging.{Level => JLevel, Logger => JLogger}

/**
 * Implementation of Logger using the "java.util.logging" facility.
 */
class JavaUtilLoggingLogger(jLogger: JLogger) extends Logger {
    def debug(message: => AnyRef) {
        log(JLevel.FINE, message)
    }
    
    def debug(message: => AnyRef, exception: => Throwable) {
        log(JLevel.FINE, message, exception)
    }
    
    def info(message: => AnyRef) {
        log(JLevel.INFO, message)
    }
    
    def info(message: => AnyRef, exception: => Throwable) {
        log(JLevel.INFO, message, exception)
    }
    
    def warn(message: => AnyRef) {
        log(JLevel.WARNING, message)
    }
    
    def warn(message: => AnyRef, exception: => Throwable) {
        log(JLevel.WARNING, message, exception)
    }
    
    def error(message: => AnyRef) {
        log(JLevel.SEVERE, message)
    }
    
    def error(message: => AnyRef, exception: => Throwable) {
        log(JLevel.SEVERE, message, exception)
    }
    
    def trace(message: => AnyRef) {
        log(JLevel.FINER, message)
    }
    
    def trace(message: => AnyRef, exception: => Throwable) {
        log(JLevel.FINER, message, exception)
    }
    
    private def log(logLevel: JLevel, message: => AnyRef, exception: => Throwable = null) {
        if (jLogger.isLoggable(logLevel)) {
            val exceptionEvaluated = exception
            if (exceptionEvaluated == null) {
                jLogger.log(logLevel, message.toString)
            } else {
                jLogger.log(logLevel, message.toString, exceptionEvaluated)
            }
        }
    }   
}