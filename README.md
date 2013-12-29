hal-json
========

A simple json HAL library
i
I created this "library" because I was exploring the HAL protocol and wanted to something very light weight and most importantly very simple. It is currently just a simple builder that serializes POJOS to JSON (using Jackson) with the option of adding links and embedded resources that align with the most basic use cases of the HAL protocol.

If you want something more complete, I would suggest you have a look at HalBuilder (https://github.com/HalBuilder) which takes a similar approach, although much more comprehensive.

