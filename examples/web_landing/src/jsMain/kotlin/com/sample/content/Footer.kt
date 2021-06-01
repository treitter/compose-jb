package com.sample.content

import androidx.compose.runtime.Composable
import androidx.compose.web.attributes.ATarget
import androidx.compose.web.attributes.target
import androidx.compose.web.css.*
import androidx.compose.web.elements.*
import com.sample.style.*


@Composable
fun PageFooter() {
    Footer({
        style {
            flexShrink(0)
            property("box-sizing", value("border-box"))
        }
    }) {
        Section({
            classes(WtSections.wtSectionBgGrayDark)
            style {
                property("padding", value("24px 0"))
            }
        }) {
            Div({ classes(WtContainer.wtContainer) }) {
                Div({
                    classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
                    style {
                        justifyContent(JustifyContent.Center)
                        flexWrap(FlexWrap.Wrap)
                    }
                }) {

                    Div({
                        classes(WtCols.wtColInline)
                    }) {
                        P({
                            classes(WtTexts.wtText1, WtTexts.wtText1ThemeDark)
                        }) {
                            Text("Follow us")
                        }
                    }

                    Div({
                        classes(WtCols.wtColInline)
                    }) {
                        getSocialLinks().forEach { SocialIconLink(it) }
                    }
                }

                CopyrightInFooter()
            }
        }
    }
}

@Composable
private fun CopyrightInFooter() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter, WtOffsets.wtTopOffset48)
        style {
            justifyContent(JustifyContent.SpaceEvenly)
            flexWrap(FlexWrap.Wrap)
            property("padding", value("0px 12px"))
        }
    }) {
        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Copyright © 2000-2021  JetBrains s.r.o.")
        }

        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Developed with drive and IntelliJ IDEA")
        }
    }
}

@Composable
private fun SocialIconLink(link: SocialLink) {
    A(attrs = {
        classes(WtTexts.wtSocialButtonItem)
        target(ATarget.Blank)
    }, href = link.url) {
        Img(src = link.iconSvg) {}
    }
}

private data class SocialLink(
    val id: String,
    val url: String,
    val title: String,
    val iconSvg: String
)

private fun getSocialLinks(): List<SocialLink> {
    return listOf(
        SocialLink("facebook", "https://www.facebook.com/JetBrains", "JetBrains on Facebook", "ic_fb.svg"),
        SocialLink("twitter", "https://twitter.com/jetbrains", "JetBrains on Twitter", "ic_twitter.svg"),
        SocialLink(
            "linkedin",
            "https://www.linkedin.com/company/jetbrains",
            "JetBrains on Linkedin",
            "ic_linkedin.svg"
        ),
        SocialLink("youtube", "https://www.youtube.com/user/JetBrainsTV", "JetBrains on YouTube", "ic_youtube.svg"),
        SocialLink("instagram", "https://www.instagram.com/jetbrains/", "JetBrains on Instagram", "ic_insta.svg"),
        SocialLink("blog", "https://blog.jetbrains.com/", "JetBrains blog", "ic_jb_blog.svg"),
        SocialLink("rss", "https://blog.jetbrains.com/feed/", "JetBrains RSS Feed", "ic_feed.svg"),
    )
}