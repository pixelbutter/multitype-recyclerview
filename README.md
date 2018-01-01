## Multi-type RecyclerView demo

**Work in progress**

Sample of RecyclerView using the delegate adapter pattern, based on and MVP architecture pattern.

![demo](https://raw.githubusercontent.com/pixelbutter/multitype-recyclerview/master/screenshots/recyclerview_demo.png)

#### Delegate Adapter Pattern

If you've worked with RecyclerViews, mostly likely you've had to support multiple item types.
In simple cases, a single adapter suffices for the varying item types.
However as number and complexity of each view type increases, it's easy for the adapter to get bloated ahd with conditional logic and various ViewHolders.

Instead we can create a delegate adapter for each item type that is in charge of managing a specific view type. This simplifies the logic of the multi-type RecyclerView adapter as well as allows reusability for item types across different RecyclerViews.

To read more about this, see posts from [Hannes Dorfmann](http://hannesdorfmann.com/android/adapter-delegates) and [Juan Ignacio Saravia](https://android.jlelse.eu/keddit-part-4-recyclerview-delegate-adapters-data-classes-with-kotlin-9248f44327f7).

#### MVP Architecture

The question often comes up on how to handle RecyclerView adapters when it comes to the MVP architecture pattern. This project uses the MVP architecture pattern. This implementation is in progress - more details to come.

#### Image Credits

* Food dish icons - Google Emojis (7.1)
* Chef images - [Overcooked](https://www.playstation.com/en-us/games/overcooked-ps4/)