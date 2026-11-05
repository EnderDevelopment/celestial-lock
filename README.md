# Vanilla Celestial Lock

A client-side Fabric mod that prevents other mods from changing the sun and moon position, ensuring they always follow the exact vanilla Minecraft movement path. This Minecraft mod locks the celestial bodies to their vanilla positions by intercepting and correcting both the sky angle calculation and the sun height dimension effects, making it invisible during normal gameplay while protecting the authentic sky experience.

## Install

1. Install **Minecraft Java Edition 1.21.1**.
2. Install a **Fabric Loader** for 1.21.1 (use the official [Fabric installer](https://fabricmc.net/use/installer/)).
3. Drop the **Fabric API** jar (1.21.1 build) into your `mods` folder.
4. Drop this mod's `endersky-1.0.0.jar` into the same `mods` folder.
5. Launch the game with the Fabric profile.

## Use

Once installed, the mod works automatically with no configuration or commands required:

- The sun and moon will always follow their vanilla movement paths, regardless of what other mods attempt to change.
- Any mod that tries to override the world's sky angle or dimension effects will be neutralized.
- The mod runs client-side only and does not affect gameplay, items, blocks, or any other features.
- No keybindings, commands, or settings to manage—just install and play.

## Building from source

Requires JDK 21 and a network connection (Gradle downloads the toolchain):

```bash
./gradlew build
```

The finished jar is written to `build/libs/endersky-1.0.0.jar`.

## License

MIT — see [LICENSE](LICENSE).

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/37027d66-dc6c-4ffb-b9d0-bf4686880f91?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=37027d66-dc6c-4ffb-b9d0-bf4686880f91
