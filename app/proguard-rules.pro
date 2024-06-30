# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile

# Repackage classes into the top-level.
-repackageclasses

# This is generated automatically by the Android Gradle plugin.
-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.conscrypt.Conscrypt$Version
-dontwarn org.conscrypt.Conscrypt
-dontwarn org.conscrypt.ConscryptHostnameVerifier
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE
-dontwarn aQute.bnd.annotation.baseline.BaselineIgnore
-dontwarn aQute.bnd.annotation.spi.ServiceConsumer
-dontwarn aQute.bnd.annotation.spi.ServiceProvider
-dontwarn com.fasterxml.jackson.dataformat.cbor.CBORFactory
-dontwarn com.fasterxml.jackson.dataformat.smile.SmileFactory
-dontwarn com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
-dontwarn com.fasterxml.jackson.dataformat.xml.XmlFactory
-dontwarn com.fasterxml.jackson.dataformat.xml.XmlMapper
-dontwarn com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
-dontwarn com.google.common.collect.ArrayListMultimap
-dontwarn com.google.common.collect.Multimap
-dontwarn com.google.gson.Gson
-dontwarn com.rometools.rome.feed.WireFeed
-dontwarn com.rometools.rome.feed.atom.Feed
-dontwarn com.rometools.rome.feed.rss.Channel
-dontwarn com.rometools.rome.io.FeedException
-dontwarn com.rometools.rome.io.WireFeedInput
-dontwarn com.rometools.rome.io.WireFeedOutput
-dontwarn edu.umd.cs.findbugs.annotations.Nullable
-dontwarn edu.umd.cs.findbugs.annotations.SuppressFBWarnings
-dontwarn io.micrometer.context.ThreadLocalAccessor
-dontwarn jakarta.json.bind.Jsonb
-dontwarn jakarta.json.bind.JsonbBuilder
-dontwarn jakarta.xml.bind.JAXBContext
-dontwarn jakarta.xml.bind.JAXBElement
-dontwarn jakarta.xml.bind.JAXBException
-dontwarn jakarta.xml.bind.MarshalException
-dontwarn jakarta.xml.bind.Marshaller
-dontwarn jakarta.xml.bind.UnmarshalException
-dontwarn jakarta.xml.bind.Unmarshaller
-dontwarn jakarta.xml.bind.annotation.XmlRootElement
-dontwarn jakarta.xml.bind.annotation.XmlType
-dontwarn java.awt.Color
-dontwarn java.awt.Font
-dontwarn java.awt.Point
-dontwarn java.awt.Rectangle
-dontwarn javax.annotation.Priority
-dontwarn javax.money.CurrencyUnit
-dontwarn javax.money.Monetary
-dontwarn javax.ws.rs.Consumes
-dontwarn javax.ws.rs.Produces
-dontwarn javax.ws.rs.core.Response
-dontwarn javax.ws.rs.core.StreamingOutput
-dontwarn javax.ws.rs.ext.MessageBodyReader
-dontwarn javax.ws.rs.ext.MessageBodyWriter
-dontwarn javax.ws.rs.ext.Provider
-dontwarn javax.xml.stream.XMLInputFactory
-dontwarn javax.xml.stream.XMLResolver
-dontwarn jdk.internal.vm.annotation.IntrinsicCandidate
-dontwarn kotlin.reflect.full.KClasses
-dontwarn kotlin.reflect.jvm.KCallablesJvm
-dontwarn kotlin.reflect.jvm.ReflectJvmMapping
-dontwarn kotlinx.serialization.BinaryFormat
-dontwarn kotlinx.serialization.DeserializationStrategy
-dontwarn kotlinx.serialization.KSerializer
-dontwarn kotlinx.serialization.SerialFormat
-dontwarn kotlinx.serialization.SerializationException
-dontwarn kotlinx.serialization.SerializationStrategy
-dontwarn kotlinx.serialization.SerializersKt
-dontwarn kotlinx.serialization.StringFormat
-dontwarn kotlinx.serialization.cbor.Cbor$Default
-dontwarn kotlinx.serialization.cbor.Cbor
-dontwarn kotlinx.serialization.descriptors.PolymorphicKind$OPEN
-dontwarn kotlinx.serialization.descriptors.SerialDescriptor
-dontwarn kotlinx.serialization.descriptors.SerialKind
-dontwarn kotlinx.serialization.json.Json$Default
-dontwarn kotlinx.serialization.json.Json
-dontwarn kotlinx.serialization.modules.SerializersModule
-dontwarn kotlinx.serialization.protobuf.ProtoBuf$Default
-dontwarn kotlinx.serialization.protobuf.ProtoBuf
-dontwarn org.codehaus.janino.ClassBodyEvaluator
-dontwarn org.glassfish.jersey.internal.spi.AutoDiscoverable
-dontwarn org.javamoney.moneta.Money
-dontwarn org.joda.time.DateTime
-dontwarn org.joda.time.DateTimeZone
-dontwarn org.joda.time.Duration
-dontwarn org.joda.time.Instant
-dontwarn org.joda.time.LocalDate
-dontwarn org.joda.time.LocalDateTime
-dontwarn org.joda.time.LocalTime
-dontwarn org.joda.time.Period
-dontwarn org.joda.time.ReadablePartial
-dontwarn org.joda.time.format.DateTimeFormat
-dontwarn org.joda.time.format.DateTimeFormatter
-dontwarn org.osgi.framework.Bundle
-dontwarn org.osgi.framework.BundleContext
-dontwarn org.osgi.framework.FrameworkUtil
-dontwarn org.osgi.framework.ServiceReference
-dontwarn reactor.blockhound.integration.BlockHoundIntegration
-dontwarn springfox.documentation.spring.web.json.Json